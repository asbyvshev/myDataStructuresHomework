package ru.geekbrains.datastructure.lesson7.teacherVersion;

public class Vertex {

    private final String label;
    private boolean visited;

    private ru.geekbrains.datastructure.lesson7.homework7.Vertex previousVertex;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public ru.geekbrains.datastructure.lesson7.homework7.Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(ru.geekbrains.datastructure.lesson7.homework7.Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }
}
