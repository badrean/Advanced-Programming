package compulsory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/*
A document may be located using a path in the local file system or a link to an external URL.
Each document has a unique ID, a name and may have additional tags, which are pairs name-value.
Example of tags may be title, author, year, publishingDate, etc.
*/
public class Document {
    private static int count;
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String path;
    @JsonProperty
    private String link;
    @JsonProperty
    private Map<Keys, String> tags;
    @JsonCreator
    public Document(@JsonProperty("name") String name, @JsonProperty("path") String path, @JsonProperty("link") String link){
        tags = new HashMap<>();
        this.id = count;
        count++;
        this.name = name;
        this.path = path;
        this.link = link;
    }

    public void addTag(Keys key, String value){
        tags.put(key, value);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", link='" + link + '\'' +
                ", tags=" + tags +
                '}';
    }

    public String getPath() {
        return path;
    }

    public String getLink() {
        return link;
    }
}
