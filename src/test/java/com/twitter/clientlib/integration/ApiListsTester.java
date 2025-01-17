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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.GenericMultipleUsersLookupResponse;
import com.twitter.clientlib.model.InvalidRequestProblem;
import com.twitter.clientlib.model.ListAddMemberRequest;
import com.twitter.clientlib.model.ListCreateRequest;
import com.twitter.clientlib.model.ListCreateResponse;
import com.twitter.clientlib.model.ListDeleteResponse;
import com.twitter.clientlib.model.ListFollowRequest;
import com.twitter.clientlib.model.ListFollowedResponse;
import com.twitter.clientlib.model.ListLookupMultipleUsersLookupResponse;
import com.twitter.clientlib.model.ListMemberResponse;
import com.twitter.clientlib.model.ListPinRequest;
import com.twitter.clientlib.model.ListPinnedResponse;
import com.twitter.clientlib.model.ListUpdateRequest;
import com.twitter.clientlib.model.ListUpdateResponse;
import com.twitter.clientlib.model.ListsIdTweetsResponse;
import com.twitter.clientlib.model.MultiListResponse;
import com.twitter.clientlib.model.SingleListLookupResponse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiListsTester extends ApiTester {

  private final String listId = "84839422";
  private final String listIdNotFound = "11111112";
  private final String listOwnerUserId = "2244994945";
  private final Set<String> listFields = new HashSet<>(
      Arrays.asList("owner_id", "follower_count", "created_at", "description"));
  private final Set<String> listsExpansions = new HashSet<>(Collections.singletonList("owner_id"));
  private final Set<String> expansionsPinnedTweetId = new HashSet<>(
      Collections.singletonList("pinned_tweet_id"));

  public ListCreateResponse listIdCreate() throws ApiException {
    ListCreateRequest request = new ListCreateRequest();
    request.setName("MyList");
    request.setPrivate(true);
    request.setDescription("MyList description");
    return apiInstance.lists().listIdCreate(request);
  }

  private ListDeleteResponse deleteList(String id) throws ApiException {
    return apiInstance.lists().listIdDelete(id);
  }

  @BeforeAll
  public void init() {
    initApiInstance();
  }

  @Test
  public void listIdGetTest() throws ApiException {
    SingleListLookupResponse result = apiInstance.lists().listIdGet(listId, listFields,
        listsExpansions,
        userFields);
    checkErrors(false, result.getErrors());
    checkListData(result.getData());
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    checkUserData(result.getIncludes().getUsers().get(0));
  }

  @Test
  public void listIdGetListNotFoundTest() throws ApiException {
    SingleListLookupResponse result = apiInstance.lists().listIdGet(listIdNotFound, listFields,
        listsExpansions, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    checkResourceNotFoundProblem(result.getErrors().get(0), listIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void listUserOwnedListsTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().listUserOwnedLists(listOwnerUserId, maxResults,
        null,
        listFields, listsExpansions, userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkListData(result.getData().get(0));
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    checkUserData(result.getIncludes().getUsers().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void listUserOwnedListsListNotFoundTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().listUserOwnedLists(userNotExists, maxResults,
        null,
        listFields, listsExpansions, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void listIdCreateTest() throws ApiException {
    ListCreateResponse result = null;
    try {
      result = listIdCreate();
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertNotNull(result.getData().getId());
      assertNotNull(result.getData().getName());
    } finally {
      if (result != null) {
        deleteList(result.getData().getId());
      }
    }
  }

  @Test
  public void listIdCreateEmptyValuesTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listIdCreate(null);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `name` field in the request body can not be empty",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listIdUpdateTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListUpdateRequest request = new ListUpdateRequest();
      request.setName("MyNewList Updated");
      request.setDescription("updated description");
      ListUpdateResponse result = apiInstance.lists().listIdUpdate(request,
          list.getData().getId());
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertTrue(result.getData().getUpdated());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listIdUpdateListNotFoundTest() throws ApiException {
    ListUpdateRequest request = new ListUpdateRequest();
    request.setName("MyNewList Updated");
    request.setDescription("updated description");
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listIdUpdate(request, listIdNotFound);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot update a List that does not exist.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listIdUpdateNullValuesTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListUpdateResponse result = apiInstance.lists().listIdUpdate(null, list.getData().getId());
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertTrue(result.getData().getUpdated());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listIdUpdateListNullTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListUpdateResponse result = apiInstance.lists().listIdUpdate(null, list.getData().getId());
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertTrue(result.getData().getUpdated());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listIdDeleteTest() throws ApiException {
    ListCreateResponse list = listIdCreate();
    ListDeleteResponse result = deleteList(list.getData().getId());
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getDeleted());
  }

  @Test
  public void listIdDeleteListNotFoundTest() throws ApiException {
    ListDeleteResponse result = deleteList(listIdNotFound);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getDeleted());
  }

  @Test
  public void listIdDeleteListNotMineTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      deleteList(listId);
    });
    checkGenericProblem(exception.getErrorObject().getProblem(),
        "You are not allowed to delete this List.", "Forbidden",
        403);
  }

  @Test
  public void listsIdTweetsTest() throws ApiException {
    ListsIdTweetsResponse result = apiInstance.tweets().listsIdTweets(listId, maxResults, null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkTweetData(result.getData().get(0));
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    checkUserData(result.getIncludes().getUsers().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void listsIdTweetsListNotFoundTest() throws ApiException {
    ListsIdTweetsResponse result = apiInstance.tweets().listsIdTweets(listIdNotFound, maxResults,
        null,
        expansions, tweetFields, userFields, null, null, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), listIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void listAddMemberTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListAddMemberRequest request = new ListAddMemberRequest();
      request.setUserId(userId);
      ListMemberResponse result = apiInstance.lists().listAddMember(request,
          list.getData().getId());
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertTrue(result.getData().getIsMember());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listAddMemberMemberNotFoundTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      String id = list.getData().getId();
      ListAddMemberRequest request = new ListAddMemberRequest();
      request.setUserId(userNotExists);
      ApiException exception = assertThrows(ApiException.class, () -> {
        apiInstance.lists().listAddMember(request, id);
      });
      checkApiExceptionProblem(exception, InvalidRequestProblem.class,
          "You cannot add a member that does not exist.",
          "Invalid Request", "One or more parameters to your request was invalid.");
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listRemoveMemberTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListAddMemberRequest addRrequest = new ListAddMemberRequest();
      addRrequest.setUserId(userId);
      apiInstance.lists().listAddMember(addRrequest, list.getData().getId());

      ListMemberResponse result = apiInstance.lists().listRemoveMember(list.getData().getId(),
          userId);
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertFalse(result.getData().getIsMember());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listRemoveMemberMemberNotFoundTest() throws ApiException {
    ListCreateResponse list = null;
    try {
      list = listIdCreate();
      ListAddMemberRequest addRrequest = new ListAddMemberRequest();
      addRrequest.setUserId(userId);
      apiInstance.lists().listAddMember(addRrequest, list.getData().getId());

      ListMemberResponse result = apiInstance.lists().listRemoveMember(list.getData().getId(),
          userNotExists);
      checkErrors(false, result.getErrors());
      assertNotNull(result.getData());
      assertFalse(result.getData().getIsMember());
    } finally {
      if (list != null) {
        deleteList(list.getData().getId());
      }
    }
  }

  @Test
  public void listGetMembersTest() throws ApiException {
    ListLookupMultipleUsersLookupResponse result = apiInstance.users().listGetMembers(listId,
        maxResults,
        null,
        expansionsPinnedTweetId, tweetFields, userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getTweets());
    checkTweetData(result.getIncludes().getTweets().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void listGetMembersListNotFoundTest() throws ApiException {
    ListLookupMultipleUsersLookupResponse result = apiInstance.users().listGetMembers(
        listIdNotFound,
        maxResults, null,
        expansionsPinnedTweetId, tweetFields, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), listIdNotFound, "Not Found Error",
        "id");
  }

  @Test
  public void getUserListMembershipsTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().getUserListMemberships(listOwnerUserId,
        maxResults, null,
        listFields, listsExpansions, userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkListData(result.getData().get(0));
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    checkUserData(result.getIncludes().getUsers().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void getUserListMembershipsListNotFoundTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().getUserListMemberships(userNotExists,
        maxResults, null,
        listFields, listsExpansions, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void usersIdFollowersTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdFollowers(popularUserId,
        maxResults, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNull(result.getIncludes());
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void usersIdFollowersUserNotExistsTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdFollowers(userNotExists,
        maxResults, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void userFollowedListsTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().userFollowedLists(popularUserId, maxResults,
        null,
        listFields, listsExpansions, userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkListData(result.getData().get(0));
    assertNotNull(result.getIncludes());
    assertNotNull(result.getIncludes().getUsers());
    checkUserData(result.getIncludes().getUsers().get(0));
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void userFollowedListsUserNotFoundTest() throws ApiException {
    MultiListResponse result = apiInstance.lists().userFollowedLists(userNotExists, maxResults,
        null,
        listFields, listsExpansions, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    assertNull(result.getIncludes());
    assertNull(result.getMeta());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void listUserFollowTest() throws ApiException {
    ListFollowRequest request = new ListFollowRequest();
    request.setListId(listId);
    ListFollowedResponse result = apiInstance.lists().listUserFollow(request, userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getFollowing());
  }

  @Test
  public void listUserFollowListNotFoundTest() throws ApiException {
    ListFollowRequest request = new ListFollowRequest();
    request.setListId(listIdNotFound);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listUserFollow(request, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot follow a List that does not exist.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listUserFollowUserNotExistsTest() throws ApiException {
    ListFollowRequest request = new ListFollowRequest();
    request.setListId(listId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listUserFollow(request, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listUserPinTest() throws ApiException {
    ListPinRequest request = new ListPinRequest();
    request.setListId(listId);
    ListPinnedResponse result = apiInstance.lists().listUserPin(request, userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getPinned());
  }

  @Test
  public void listUserPinListNotFoundTest() throws ApiException {
    ListPinRequest request = new ListPinRequest();
    request.setListId(listIdNotFound);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listUserPin(request, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot pin a List that does not exist.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listUserPinUserNotExistsTest() throws ApiException {
    ListPinRequest request = new ListPinRequest();
    request.setListId(listId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listUserPin(request, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void listUserUnpinTest() throws ApiException {
    ListPinnedResponse result = apiInstance.lists().listUserUnpin(userId, listId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getPinned());
  }

  @Test
  public void listUserUnpinListNotFoundTest() throws ApiException {
    ListPinnedResponse result = apiInstance.lists().listUserUnpin(userId, listIdNotFound);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getPinned());
  }

  @Test
  public void listUserUnpinUserNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.lists().listUserUnpin(userNotExists, listId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }
}
