package task2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TaskDto {
    private final String id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private Set<String> tags = new HashSet<>();

    public TaskDto(String id, String title, TaskType type, LocalDate createdOn) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", createdOn=" + createdOn +
                ", tags=" + tags +
                '}';
    }
}