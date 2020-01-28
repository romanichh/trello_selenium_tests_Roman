package com.roman.trello.model;

public class BoardData {
    private String boardName;

    public String getBoardName() {
        return boardName;
    }

    public BoardData setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    @Override
    public String toString() {
        return "BoardData " +
                "boardName='" + boardName + '\'' +
                '}';
    }
}
