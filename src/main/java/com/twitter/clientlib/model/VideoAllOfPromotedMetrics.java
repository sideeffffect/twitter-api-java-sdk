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


package com.twitter.clientlib.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.twitter.clientlib.JSON;

/**
 * Promoted nonpublic engagement metrics for the Media at the time of the request.
 */
@ApiModel(description = "Promoted nonpublic engagement metrics for the Media at the time of the request.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class VideoAllOfPromotedMetrics {
  public static final String SERIALIZED_NAME_PLAYBACK0_COUNT = "playback_0_count";
  @SerializedName(SERIALIZED_NAME_PLAYBACK0_COUNT)
  private Integer playback0Count;

  public static final String SERIALIZED_NAME_PLAYBACK25_COUNT = "playback_25_count";
  @SerializedName(SERIALIZED_NAME_PLAYBACK25_COUNT)
  private Integer playback25Count;

  public static final String SERIALIZED_NAME_PLAYBACK50_COUNT = "playback_50_count";
  @SerializedName(SERIALIZED_NAME_PLAYBACK50_COUNT)
  private Integer playback50Count;

  public static final String SERIALIZED_NAME_PLAYBACK75_COUNT = "playback_75_count";
  @SerializedName(SERIALIZED_NAME_PLAYBACK75_COUNT)
  private Integer playback75Count;

  public static final String SERIALIZED_NAME_PLAYBACK100_COUNT = "playback_100_count";
  @SerializedName(SERIALIZED_NAME_PLAYBACK100_COUNT)
  private Integer playback100Count;

  public static final String SERIALIZED_NAME_VIEW_COUNT = "view_count";
  @SerializedName(SERIALIZED_NAME_VIEW_COUNT)
  private Integer viewCount;

  public VideoAllOfPromotedMetrics() { 
  }

  public VideoAllOfPromotedMetrics playback0Count(Integer playback0Count) {
    
    this.playback0Count = playback0Count;
    return this;
  }

   /**
   * Number of users who made it through 0% of the video.
   * @return playback0Count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of users who made it through 0% of the video.")

  public Integer getPlayback0Count() {
    return playback0Count;
  }


  public void setPlayback0Count(Integer playback0Count) {
    this.playback0Count = playback0Count;
  }


  public VideoAllOfPromotedMetrics playback25Count(Integer playback25Count) {
    
    this.playback25Count = playback25Count;
    return this;
  }

   /**
   * Number of users who made it through 25% of the video.
   * @return playback25Count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of users who made it through 25% of the video.")

  public Integer getPlayback25Count() {
    return playback25Count;
  }


  public void setPlayback25Count(Integer playback25Count) {
    this.playback25Count = playback25Count;
  }


  public VideoAllOfPromotedMetrics playback50Count(Integer playback50Count) {
    
    this.playback50Count = playback50Count;
    return this;
  }

   /**
   * Number of users who made it through 50% of the video.
   * @return playback50Count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of users who made it through 50% of the video.")

  public Integer getPlayback50Count() {
    return playback50Count;
  }


  public void setPlayback50Count(Integer playback50Count) {
    this.playback50Count = playback50Count;
  }


  public VideoAllOfPromotedMetrics playback75Count(Integer playback75Count) {
    
    this.playback75Count = playback75Count;
    return this;
  }

   /**
   * Number of users who made it through 75% of the video.
   * @return playback75Count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of users who made it through 75% of the video.")

  public Integer getPlayback75Count() {
    return playback75Count;
  }


  public void setPlayback75Count(Integer playback75Count) {
    this.playback75Count = playback75Count;
  }


  public VideoAllOfPromotedMetrics playback100Count(Integer playback100Count) {
    
    this.playback100Count = playback100Count;
    return this;
  }

   /**
   * Number of users who made it through 100% of the video.
   * @return playback100Count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of users who made it through 100% of the video.")

  public Integer getPlayback100Count() {
    return playback100Count;
  }


  public void setPlayback100Count(Integer playback100Count) {
    this.playback100Count = playback100Count;
  }


  public VideoAllOfPromotedMetrics viewCount(Integer viewCount) {
    
    this.viewCount = viewCount;
    return this;
  }

   /**
   * Number of times this video has been viewed.
   * @return viewCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of times this video has been viewed.")

  public Integer getViewCount() {
    return viewCount;
  }


  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoAllOfPromotedMetrics videoAllOfPromotedMetrics = (VideoAllOfPromotedMetrics) o;
    return Objects.equals(this.playback0Count, videoAllOfPromotedMetrics.playback0Count) &&
        Objects.equals(this.playback25Count, videoAllOfPromotedMetrics.playback25Count) &&
        Objects.equals(this.playback50Count, videoAllOfPromotedMetrics.playback50Count) &&
        Objects.equals(this.playback75Count, videoAllOfPromotedMetrics.playback75Count) &&
        Objects.equals(this.playback100Count, videoAllOfPromotedMetrics.playback100Count) &&
        Objects.equals(this.viewCount, videoAllOfPromotedMetrics.viewCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playback0Count, playback25Count, playback50Count, playback75Count, playback100Count, viewCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VideoAllOfPromotedMetrics {\n");
    sb.append("    playback0Count: ").append(toIndentedString(playback0Count)).append("\n");
    sb.append("    playback25Count: ").append(toIndentedString(playback25Count)).append("\n");
    sb.append("    playback50Count: ").append(toIndentedString(playback50Count)).append("\n");
    sb.append("    playback75Count: ").append(toIndentedString(playback75Count)).append("\n");
    sb.append("    playback100Count: ").append(toIndentedString(playback100Count)).append("\n");
    sb.append("    viewCount: ").append(toIndentedString(viewCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("playback_0_count");
    openapiFields.add("playback_25_count");
    openapiFields.add("playback_50_count");
    openapiFields.add("playback_75_count");
    openapiFields.add("playback_100_count");
    openapiFields.add("view_count");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to VideoAllOfPromotedMetrics
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (VideoAllOfPromotedMetrics.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has reuqired fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in VideoAllOfPromotedMetrics is not found in the empty JSON string", VideoAllOfPromotedMetrics.openapiRequiredFields.toString()));
        }
      }
      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!VideoAllOfPromotedMetrics.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `VideoAllOfPromotedMetrics` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!VideoAllOfPromotedMetrics.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'VideoAllOfPromotedMetrics' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<VideoAllOfPromotedMetrics> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(VideoAllOfPromotedMetrics.class));

       return (TypeAdapter<T>) new TypeAdapter<VideoAllOfPromotedMetrics>() {
           @Override
           public void write(JsonWriter out, VideoAllOfPromotedMetrics value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public VideoAllOfPromotedMetrics read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of VideoAllOfPromotedMetrics given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of VideoAllOfPromotedMetrics
  * @throws IOException if the JSON string is invalid with respect to VideoAllOfPromotedMetrics
  */
  public static VideoAllOfPromotedMetrics fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, VideoAllOfPromotedMetrics.class);
  }

 /**
  * Convert an instance of VideoAllOfPromotedMetrics to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

