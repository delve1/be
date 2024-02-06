package com.example.projectbe.oauth.userInfo;

import java.util.Map;

public class GithubOAuth2UserInfo extends OAuth2UserInfo {

    public GithubOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getNickname() {
        return (String) attributes.get("name");
    }

    @Override
    public String getProfileImage() {
        return (String) attributes.get("image");
    }
}
