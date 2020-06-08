package com.catering.in.CateringBusinessAuth.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "oauth_client_details")
@Getter
@Setter
@ToString
public class OauthClientDetails {

    @Id
    @NonNull
    private String client_id;

    @NonNull
    private String client_secret;

    private String web_server_redirect_uri;
    private String scope;
    private String access_token_validity;
    private String refresh_token_validity;
    private String resource_ids;
    private String authorized_grant_types;
    private String additional_information;

    public OauthClientDetails(@NonNull String client_id, @NonNull String client_secret, String web_server_redirect_uri, String scope, String access_token_validity, String refresh_token_validity, String resource_ids, String authorized_grant_types, String additional_information) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.web_server_redirect_uri = web_server_redirect_uri;
        this.scope = scope;
        this.access_token_validity = access_token_validity;
        this.refresh_token_validity = refresh_token_validity;
        this.resource_ids = resource_ids;
        this.authorized_grant_types = authorized_grant_types;
        this.additional_information = additional_information;
    }
}
