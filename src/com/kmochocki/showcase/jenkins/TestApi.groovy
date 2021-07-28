package com.kmochocki.showcase.jenkins

class TestApi {

    def getApi() {
        return new GitLabApi("http://your.gitlab.server.com", "YOUR_PERSONAL_ACCESS_TOKEN");
    }
}
