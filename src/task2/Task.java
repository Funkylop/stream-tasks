package task2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task {
    private String id;
    private String title;
    private final TaskType type;
    private final LocalDate createdOn;



    private boolean done = false;
    private Set<String> tags = new HashSet<>();
    private LocalDate dueTo;

    public Task(String title, TaskType type, LocalDate createdOn) {
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Task addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public LocalDate getDueTo() {
        return dueTo;
    }

    public void setDueTo(LocalDate dueTo) {
        this.dueTo = dueTo;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return done == task.done && Objects.equals(id, task.id) && Objects.equals(title, task.title) && type == task.type && Objects.equals(createdOn, task.createdOn) && Objects.equals(tags, task.tags) && Objects.equals(dueTo, task.dueTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, createdOn, done, tags, dueTo);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", createdOn=" + createdOn +
                ", done=" + done +
                ", tags=" + tags +
                ", dueTo=" + dueTo +
                '}';
    }
}
