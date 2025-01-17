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
import java.util.ArrayList;
import java.util.List;

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
 * IDs and values of all deleted user-specified stream filtering rules.
 */
@ApiModel(description = "IDs and values of all deleted user-specified stream filtering rules.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DeleteRulesRequestDelete {
  public static final String SERIALIZED_NAME_IDS = "ids";
  @SerializedName(SERIALIZED_NAME_IDS)
  private List<String> ids = null;

  public static final String SERIALIZED_NAME_VALUES = "values";
  @SerializedName(SERIALIZED_NAME_VALUES)
  private List<String> values = null;

  public DeleteRulesRequestDelete() { 
  }

  public DeleteRulesRequestDelete ids(List<String> ids) {
    
    this.ids = ids;
    return this;
  }

  public DeleteRulesRequestDelete addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<>();
    }
    this.ids.add(idsItem);
    return this;
  }

   /**
   * IDs of all deleted user-specified stream filtering rules.
   * @return ids
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "IDs of all deleted user-specified stream filtering rules.")

  public List<String> getIds() {
    return ids;
  }


  public void setIds(List<String> ids) {
    this.ids = ids;
  }


  public DeleteRulesRequestDelete values(List<String> values) {
    
    this.values = values;
    return this;
  }

  public DeleteRulesRequestDelete addValuesItem(String valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

   /**
   * Values of all deleted user-specified stream filtering rules.
   * @return values
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Values of all deleted user-specified stream filtering rules.")

  public List<String> getValues() {
    return values;
  }


  public void setValues(List<String> values) {
    this.values = values;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteRulesRequestDelete deleteRulesRequestDelete = (DeleteRulesRequestDelete) o;
    return Objects.equals(this.ids, deleteRulesRequestDelete.ids) &&
        Objects.equals(this.values, deleteRulesRequestDelete.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteRulesRequestDelete {\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
    openapiFields.add("ids");
    openapiFields.add("values");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DeleteRulesRequestDelete
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (DeleteRulesRequestDelete.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has reuqired fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in DeleteRulesRequestDelete is not found in the empty JSON string", DeleteRulesRequestDelete.openapiRequiredFields.toString()));
        }
      }
      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DeleteRulesRequestDelete.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DeleteRulesRequestDelete` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DeleteRulesRequestDelete.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DeleteRulesRequestDelete' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DeleteRulesRequestDelete> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DeleteRulesRequestDelete.class));

       return (TypeAdapter<T>) new TypeAdapter<DeleteRulesRequestDelete>() {
           @Override
           public void write(JsonWriter out, DeleteRulesRequestDelete value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DeleteRulesRequestDelete read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DeleteRulesRequestDelete given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DeleteRulesRequestDelete
  * @throws IOException if the JSON string is invalid with respect to DeleteRulesRequestDelete
  */
  public static DeleteRulesRequestDelete fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DeleteRulesRequestDelete.class);
  }

 /**
  * Convert an instance of DeleteRulesRequestDelete to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

