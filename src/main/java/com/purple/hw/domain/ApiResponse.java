package com.purple.hw.domain;

public class ApiResponse {
    private String status;
    private String msg;
    private Embed embed;

    public ApiResponse(String status, String msg, Embed embed) {
        this.status = status;
        this.msg = msg;
        this.embed = embed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Embed getEmbed() {
        return embed;
    }

    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", embed=" + embed +
                '}';
    }
}
