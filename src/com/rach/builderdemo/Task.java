package com.rach.builderdemo;


public class Task {

    public static class TaskBuilderA {

        private final long id;
        private String summary = "";
        private String description = "";
        private boolean done = false;

        public TaskBuilderA(long id) {
            this.id = id;
        }

        public TaskBuilderA setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public TaskBuilderA setDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilderA setDone(boolean done) {
            this.done = done;
            return this;
        }

        public Task build() {
            return new Task(id, summary, description, done);
        }
    }

    public static class TaskBuilderB {

        private final long id;
        private String summary = "";
        private boolean done = false;

        public TaskBuilderB(long id) {
            this.id = id;
        }

        public TaskBuilderB setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public TaskBuilderB setDone(boolean done) {
            this.done = done;
            return this;
        }

        public Task build() {
            return new Task(id, summary, done);
        }
    }

    private final long id;
    private String summary = "";
    private String description = "";
    private boolean done = false;


    private Task(long id) {
        this.id = id;
    }

    private Task(long id, String summary) {
        this.id = id;
        this.summary = summary;
    }

    private Task(long id, String summary, boolean done) {
        this.id = id;
        this.summary = summary;
        this.description = summary;
    }

    private Task(long id, String summary, String description, boolean done) {
        this.id = id;
        this.summary = summary;
        this.description = summary;
        this.done = done;
    }

}