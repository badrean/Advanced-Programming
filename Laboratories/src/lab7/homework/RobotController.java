package lab7.homework;

import lab7.compulsory.Robot;

import java.util.List;
import java.util.Scanner;

public class RobotController {
    static private List<Robot> robotList;
    private static final long TIME_LIMIT = 30000; // in milliseconds
    final static private Runnable timeFunction = () -> {
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        while (elapsedTime < TIME_LIMIT && checkThreadsRunning()) {
            elapsedTime = System.currentTimeMillis() - startTime;
        }
        if (elapsedTime >= TIME_LIMIT) {
            System.out.println("Time limit exceeded.\nStopping the running robots...");
            for (Robot robot : robotList) {
                robot.setRunning(false);
            }
        }
        else
            System.out.println("The exploration took " + elapsedTime/1000 + " seconds.");
    };
    final static private Thread timekeeper = new Thread(timeFunction);

    public RobotController(List<Robot> robots) {
        robotList = robots;
        timekeeper.setDaemon(true);
    }

    public void waitUserInput() {
        Scanner input = new Scanner(System.in);
        while (!checkThreadsRunning()) {
            String firstInput = input.nextLine();
            switch (firstInput) {
                case "s" -> {
                    int n = input.nextInt(); // 0 all or 1...n the id of the robot
                    startRobots(n);
                }
                case "p" -> {
                    int n = input.nextInt(); // 0 all or 1...n the id of the robot
                    int m = input.nextInt(); // 0 for indefinite time, value in seconds
                    pauseRobots(n, m);
                }
            }
        }
        while (!Robot.getUnvisitedCells().empty() && checkThreadsRunning()) {
            String line = input.nextLine();
            switch (line) {
                case "s" -> {
                    int n = input.nextInt(); // 0 all or 1...n the id of the robot
                    startRobots(n);
                }
                case "p" -> {
                    int n = input.nextInt(); // 0 all or 1...n the id of the robot
                    int m = input.nextInt(); // 0 for indefinite time, value in seconds
                    pauseRobots(n, m);
                }
            }
        }
    }

    private static boolean checkThreadsRunning() {
        for (Robot robot : robotList) {
            if (robot.isRunning()) return true;
        }
        return false;
    }

    public void startRobots(int value) {
        if (value == 0) {
            for (Robot robot : robotList) {
                if (!robot.isRunning()) {
                    System.out.println(robot.getRobotName() + " has started!");
                    robot.setRunning(true);
                    robot.start();
                } else {
                    if (robot.isPaused()) {
                        System.out.println(robot.getRobotName() + " rejoined!");
                        robot.setPaused(false);
                    } else {
                        System.out.println(robot.getRobotName() + " is already running");
                    }
                }
            }
        } else {
            try {
                if (value > robotList.size() || value < 1) {
                    throw new IndexOutOfBoundsException();
                }

                if (!robotList.get(value - 1).isRunning()) {
                    System.out.println(robotList.get(value - 1).getRobotName() + " has started!");
                    robotList.get(value - 1).setRunning(true);
                    robotList.get(value - 1).start();
                } else {
                    if (robotList.get(value - 1).isPaused()) {
                        System.out.println(robotList.get(value - 1).getRobotName() + " rejoined!");
                        robotList.get(value - 1).setPaused(false);
                    } else {
                        System.out.println(robotList.get(value - 1).getRobotName() + " is already running");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        timekeeper.start();
    }

    public void pauseRobots(int value, int time) {
        if (value == 0) {
            for (Robot robot : robotList) {
                if (!robot.isRunning())
                    System.out.println(robot.getRobotName() + " is not running");
                else {
                    if (robot.isPaused()) {
                        System.out.println(robot.getRobotName() + " is already paused");
                    } else {
                        robot.setPaused(true);
                        if (time == 0) {
                            System.out.println(robot.getRobotName() + " was paused.");
                        } else {
                            System.out.println(robot.getRobotName() + " was paused for " + time + " seconds.");
                        }

                    }
                }
            }
            timedPauseAll(time);
        } else {
            try {
                if (value > robotList.size() || value < 1) {
                    throw new IndexOutOfBoundsException();
                }

                if (!robotList.get(value - 1).isRunning()) {
                    System.out.println(robotList.get(value - 1).getRobotName() + " is not running");
                } else {
                    if (robotList.get(value - 1).isPaused()) {
                        System.out.println(robotList.get(value - 1).getRobotName() + " is already paused");
                    } else {
                        robotList.get(value - 1).setPaused(true);
                        if (time == 0) {
                            System.out.println(robotList.get(value - 1).getRobotName() + " was paused.");
                        } else {
                            System.out.println(robotList.get(value - 1).getRobotName() + " was paused for " + time + " seconds.");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            timedPauseOne(value, time);
        }
    }

    private void timedPauseAll(int time) {
        if (time != 0) {
            Runnable basic = () -> {
                long startTime = System.currentTimeMillis();
                long elapsedTime = System.currentTimeMillis() - startTime;

                while (elapsedTime < time * 1000) {
                    elapsedTime = System.currentTimeMillis() - startTime;
                }
                for (Robot robot : robotList) {
                    robot.setPaused(false);
                    System.out.println(robot.getRobotName() + " resumed.");
                }
            };

            Thread timerThread = new Thread(basic);
            timerThread.start();
        }
    }

    private void timedPauseOne(int value, int time) {
        if (time != 0) {
            Runnable basic = () -> {
                long startTime = System.currentTimeMillis();
                long elapsedTime = System.currentTimeMillis() - startTime;

                while (elapsedTime < time * 1000) {
                    elapsedTime = System.currentTimeMillis() - startTime;
                }
                robotList.get(value - 1).setPaused(false);
                System.out.println(robotList.get(value - 1).getRobotName() + " resumed.");
            };

            Thread timerThread = new Thread(basic);
            timerThread.start();
        }
    }

    public void joinThreads() {
        for (Robot robot : robotList) {
            try {
                robot.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
