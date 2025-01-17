/*
Copyright 2020 Twitter, Inc.
SPDX-License-Identifier: Apache-2.0

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
https://openapi-generator.tech
Do not edit the class manually.
*/


package com.twitter.clientlib.integration;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.AddOrDeleteRulesRequest;
import com.twitter.clientlib.model.AddOrDeleteRulesResponse;
import com.twitter.clientlib.model.AddRulesRequest;
import com.twitter.clientlib.model.CreateTweetRequest;
import com.twitter.clientlib.model.CreateTweetRequestMedia;
import com.twitter.clientlib.model.DeleteRulesRequest;
import com.twitter.clientlib.model.DeleteRulesRequestDelete;
import com.twitter.clientlib.model.GenericMultipleUsersLookupResponse;
import com.twitter.clientlib.model.GenericTweetsTimelineResponse;
import com.twitter.clientlib.model.InvalidRequestProblem;
import com.twitter.clientlib.model.MultiTweetLookupResponse;
import com.twitter.clientlib.model.QuoteTweetLookupResponse;
import com.twitter.clientlib.model.RuleNoId;
import com.twitter.clientlib.model.SingleTweetLookupResponse;
import com.twitter.clientlib.model.TweetCountsResponse;
import com.twitter.clientlib.model.TweetCreateResponse;
import com.twitter.clientlib.model.TweetCreateResponseData;
import com.twitter.clientlib.model.TweetDeleteResponse;
import com.twitter.clientlib.model.TweetDeleteResponseData;
import com.twitter.clientlib.model.TweetSearchResponse;
import com.twitter.clientlib.model.User;
import com.twitter.clientlib.model.UsersIdLikedTweetsResponse;
import com.twitter.clientlib.model.UsersLikesCreateRequest;
import com.twitter.clientlib.model.UsersLikesCreateResponse;
import com.twitter.clientlib.model.UsersLikesDeleteResponse;
import com.twitter.clientlib.model.UsersRetweetsCreateRequest;
import com.twitter.clientlib.model.UsersRetweetsCreateResponse;
import com.twitter.clientlib.model.UsersRetweetsDeleteResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTweetTester extends ApiTester {

  private List<String> tweetIds = Arrays.asList(tweetId);
  private List<String> tweetIdsNotFound = Arrays.asList(tweetIdNotFound);
  private String query = "dog OR cat";
  private String queryNotFound = "queryNotFound zaq12wsx cde34rfv";
  private String ruleValue = "song";

  @BeforeAll
  public void init() {
    initApiInstance();
  }

  @Test
  public void findTweetByIdTest() throws ApiException {
    SingleTweetLookupResponse result = apiInstance.tweets().findTweetById(tweetId, expansions,
        tweetFields,
        userFields,
        null, null, null);
    checkErrors(false, result.getErrors());
    checkTweetData(result.getData());
    checkTweetIncludes(result.getIncludes());
  }

  @Test
  public void findTweetByIdErrorTest() throws ApiException {
    SingleTweetLookupResponse result = apiInstance.tweets().findTweetById(tweetIdNotFound,
        expansions,
        tweetFields, userFields,
        null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), tweetIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void findTweetsByIdTest() throws ApiException {
    MultiTweetLookupResponse result = apiInstance.tweets().findTweetsById(tweetIds, expansions,
        tweetFields,
        userFields,
        null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    checkTweetIncludes(result.getIncludes());
  }

  @Test
  public void findTweetsByIdErrorTest() throws ApiException {
    MultiTweetLookupResponse result = apiInstance.tweets().findTweetsById(tweetIdsNotFound,
        expansions,
        tweetFields, userFields,
        null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), tweetIdNotFound, "Not Found Error",
        "ids");
  }

  @Test
  public void tweetsRecentSearchTest() throws ApiException {
    TweetSearchResponse result = apiInstance.tweets().tweetsRecentSearch(query, null, null, null,
        null,
        maxResults, null,
        null, null, expansions, tweetFields, userFields,
        null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    checkTweetIncludes(result.getIncludes());
  }

  @Test
  public void tweetsRecentSearchNoTweetFoundTest() throws ApiException {
    TweetSearchResponse result = apiInstance.tweets().tweetsRecentSearch(queryNotFound, null, null,
        null,
        null, maxResults, null,
        null, null, expansions, tweetFields, userFields,
        null, null, null);
    checkErrors(false, result.getErrors());
    assertNull(result.getData());
    assertNotNull(result.getMeta());
    assertEquals(0, (int) result.getMeta().getResultCount());
  }

  @Test
  public void createDeleteTweetTest() throws ApiException {
    CreateTweetRequest req = new CreateTweetRequest();
    req.setText("createTweetTest");
    TweetCreateResponse result = apiInstance.tweets().createTweet(req);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    TweetCreateResponseData tweet = result.getData();
    assertNotNull(tweet.getText());
    assertNotNull(tweet.getId());
    String toDeleteId = tweet.getId();

    TweetDeleteResponse deleteResponse = apiInstance.tweets().deleteTweetById(toDeleteId);
    checkErrors(false, deleteResponse.getErrors());
    assertNotNull(deleteResponse.getData());
    TweetDeleteResponseData deleteData = deleteResponse.getData();
    assertTrue(deleteData.getDeleted());
  }

  @Test
  public void deleteTweetByIdhTweetNotFoundTest() throws ApiException {
    TweetDeleteResponse result = apiInstance.tweets().deleteTweetById(tweetIdNotFound);
    assertNotNull(result.getData());
    assertTrue(result.getData().getDeleted());
    checkErrors(false, result.getErrors());
  }

  @Test
  public void createDeleteTweetErrorTest() throws ApiException {
    CreateTweetRequest req = new CreateTweetRequest();
    req.setText("createTweetTest");
    CreateTweetRequestMedia media = new CreateTweetRequestMedia();
    media.setMediaIds(Arrays.asList(tweetIdNotFound));
    req.setMedia(media);

    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.tweets().createTweet(req);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class, "Your media IDs are invalid.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdTweetsTest() throws ApiException {
    GenericTweetsTimelineResponse result = apiInstance.tweets().usersIdTweets(userId, null, null,
        maxResults,
        null, null, null, null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    checkTweetIncludes(result.getIncludes());
  }

  @Test
  public void usersIdTweetsNotFoundTest() throws ApiException {
    GenericTweetsTimelineResponse result = apiInstance.tweets().usersIdTweets(userNotExists, null,
        null,
        maxResults,
        null, null, null, null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void usersIdMentionsTest() throws ApiException {
    GenericTweetsTimelineResponse result = apiInstance.tweets().usersIdMentions(popularUserId,
        null, null,
        maxResults,
        null, null, null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    checkTweetIncludes(result.getIncludes());
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void usersIdMentionsNotFoundTest() throws ApiException {
    GenericTweetsTimelineResponse result = apiInstance.tweets().usersIdMentions(userNotExists,
        null, null,
        maxResults,
        null, null, null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void tweetsIdRetweetingUsersTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().tweetsIdRetweetingUsers(
        tweetIdPopular,
        maxResults, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    User user = result.getData().get(0);
    checkUserData(user);
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void tweetsIdRetweetingUsersNotFoundTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().tweetsIdRetweetingUsers(
        tweetIdNotFound,
        maxResults, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), tweetIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void usersIdRetweetsTest() throws ApiException {
    UsersRetweetsCreateRequest usersRetweetsCreateRequest = new UsersRetweetsCreateRequest();
    usersRetweetsCreateRequest.setTweetId(tweetIdPopular);
    UsersRetweetsCreateResponse result = apiInstance.tweets().usersIdRetweets(
        usersRetweetsCreateRequest,
        userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getRetweeted());
  }

  @Test
  public void usersIdRetweetsNotFoundTest() throws ApiException {
    UsersRetweetsCreateRequest usersRetweetsCreateRequest = new UsersRetweetsCreateRequest();
    usersRetweetsCreateRequest.setTweetId(tweetIdNotFound);

    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.tweets().usersIdRetweets(usersRetweetsCreateRequest, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class, "This Tweet cannot be found.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnretweetsTest() throws ApiException {
    UsersRetweetsDeleteResponse result = apiInstance.tweets().usersIdUnretweets(userId,
        tweetIdPopular);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getRetweeted());
  }

  @Test
  public void usersIdUnretweetsNotFoundTest() throws ApiException {
    UsersRetweetsDeleteResponse result = apiInstance.tweets().usersIdUnretweets(userId,
        tweetIdPopular);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getRetweeted());
  }

  @Test
  public void tweetsIdLikingUsersTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().tweetsIdLikingUsers(
        tweetIdPopular,
        maxResults, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    User user = result.getData().get(0);
    checkUserData(user);
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void tweetsIdLikingUsersNotFoundTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().tweetsIdLikingUsers(
        tweetIdNotFound,
        maxResults, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), tweetIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void usersIdLikedTweetsTest() throws ApiException {
    UsersIdLikedTweetsResponse result = apiInstance.tweets().usersIdLikedTweets(popularUserId,
        maxResults,
        null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    checkTweetIncludes(result.getIncludes());
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void usersIdLikedTweetsNotFoundTest() throws ApiException {
    UsersIdLikedTweetsResponse result = apiInstance.tweets().usersIdLikedTweets(tweetIdNotFound,
        maxResults,
        null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), tweetIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void usersIdUnlikeTest() throws ApiException {
    UsersLikesDeleteResponse result = apiInstance.tweets().usersIdUnlike(userId, tweetIdPopular);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getLiked());
  }

  @Test
  public void usersIdLikeTest() throws ApiException {
    UsersLikesCreateRequest usersLikesCreateRequest = new UsersLikesCreateRequest();
    usersLikesCreateRequest.setTweetId(tweetIdPopular);
    UsersLikesCreateResponse result = apiInstance.tweets().usersIdLike(usersLikesCreateRequest,
        userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getLiked());
  }

  @Test
  public void usersIdLikeTweetNotFoundTest() throws ApiException {
    UsersLikesCreateRequest usersLikesCreateRequest = new UsersLikesCreateRequest();
    usersLikesCreateRequest.setTweetId(tweetIdNotFound);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.tweets().usersIdLike(usersLikesCreateRequest, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class, "This tweet cannot be found.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdLikeUserNotFoundTest() throws ApiException {
    UsersLikesCreateRequest usersLikesCreateRequest = new UsersLikesCreateRequest();
    usersLikesCreateRequest.setTweetId(tweetIdPopular);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.tweets().usersIdLike(usersLikesCreateRequest, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user [" + userId + "]",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  /* Does not work for now
    Streaming
*/

/* academic
  @Test
  public void tweetsFullarchiveSearchTest() throws ApiException {
    TweetSearchResponse result = apiInstance.tweets().tweetsFullarchiveSearch(query, null, null, null, null, maxResults, null,
        expansions, tweetFields, userFields,
        null, null, null);
    assertFalse(result.getErrors() != null && result.getErrors().size() > 0);
    assertNotNull(result.getData());
    assertNotNull(result.getData().get(0));
    Tweet tweet = result.getData().get(0);
    assertNotNull(tweet.getText());
    assertNotNull(tweet.getAuthorId());
    assertNotNull(tweet.getCreatedAt());
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    assertNotNull(result.getIncludes().getUsers().get(0));
    assertNotNull(result.getIncludes().getUsers().get(0).getUsername());
  }

  @Test
  public void tweetsFullarchiveSearchNoTweetFoundTest() throws ApiException {
    TweetSearchResponse result = apiInstance.tweets().tweetsFullarchiveSearch(queryNotFound, null, null, null, null, maxResults, null,
        expansions, tweetFields, userFields,
        null, null, null);
    assertFalse(result.getErrors() != null && result.getErrors().size() > 0);
    assertNull(result.getData());
    assertNotNull(result.getMeta());
    assertEquals(0, (int) result.getMeta().getResultCount());
  }

  @Test
  public void tweetCountsFullArchiveSearchTest() throws ApiException {
    TweetCountsResponse result = apiInstance.tweets().tweetCountsFullArchiveSearch(query, null, null,
        null, null, null, null);
    assertFalse(result.getErrors() != null && result.getErrors().size() > 0);
    assertNotNull(result.getData());
    assertNotNull(result.getData().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getTotalTweetCount() > 0);
  }

  @Test
  public void tweetCountsFullArchiveSearchNotFoundTest() throws ApiException {
    TweetCountsResponse result = apiInstance.tweets().tweetCountsFullArchiveSearch(queryNotFound, null, null,
        null, null, null, null);
    assertFalse(result.getErrors() != null && result.getErrors().size() > 0);
    assertNotNull(result.getData());
    assertNotNull(result.getData().get(0));
    assertEquals(0, (int) result.getData().get(0).getTweetCount());
    assertNotNull(result.getMeta());
    assertEquals(0, (int) result.getMeta().getTotalTweetCount());
  }
  */
}
