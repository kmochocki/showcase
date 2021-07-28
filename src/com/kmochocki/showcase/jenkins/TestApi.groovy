package com.kmochocki.showcase.jenkins

class TestApi {

    def getApi() {
        return GitLabApi.oauth2Login("asdf", "asdf", "asdf");
    }
}
