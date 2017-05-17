package edu.hlju.boler.datadictory;

public enum EmailDataDict {
    NEW_APPLICATION("求职申请", "您收到一份新的求职申请"),
    APPLICATION_STATE_UPDATED("求职申请新动态", "您的求职申请状态被更新"),
    INTERVIEW_INVITATION("面试邀请", "您有一份面试邀请"),
    APPLICATION_REFUSED("求职申请已被回绝", "您的求职申请已被回绝");

    private String subject;
    private String text;

    private EmailDataDict(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

}
