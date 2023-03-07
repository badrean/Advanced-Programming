package lab3.compulsory;

import org.jetbrains.annotations.NotNull;

public class Company implements Comparable, Node{
    String name;

    Company(String name){
        this.name = name;
    }
    @Override
    public int compareTo(@NotNull Object obj) {
        if(obj == this){
            return 0;
        }
        if(!(obj instanceof Node)){
            return -1;
        }
        Node auxiliary = (Node) obj;
        String auxiliaryName = auxiliary.getName();
        String thisName = this.getName();
        int indx = 0;
        while(indx < thisName.length() && indx < auxiliaryName.length()){
            if(thisName.charAt(indx) < auxiliaryName.charAt(indx)){
                return -1;
            }
            if(thisName.charAt(indx) > auxiliaryName.charAt(indx)){
                return 1;
            }
            if(indx >= thisName.length()){
                return -1; //the word compared has more letters than this, so it's greater than this
            }
            if(indx >= auxiliaryName.length()){
                return 1; //this word has more letters than the compared word, so this is greater
            }
            indx++;
        }
        return 0;
    }

    @Override
    public String getName() {
        return "Person: " + name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
