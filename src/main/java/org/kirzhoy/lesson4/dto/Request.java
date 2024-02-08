package org.kirzhoy.lesson4.dto;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Request {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "item",
            "aisle",
            "parse"
    })
       @JsonProperty("item")
        private String item;
        @JsonProperty("aisle")
        private String aisle;
        @JsonProperty("parse")
        private Boolean parse;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        @JsonProperty("item")
        public String getItem(String id) {
            return item;
        }

        @JsonProperty("item")
        public void setItem(String item) {
            this.item = item;
        }

        @JsonProperty("aisle")
        public String getAisle() {
            return aisle;
        }

        @JsonProperty("aisle")
        public void setAisle(String aisle) {
            this.aisle = aisle;
        }

        @JsonProperty("parse")
        public Boolean getParse() {
            return parse;
        }

        @JsonProperty("parse")
        public void setParse(Boolean parse) {
            this.parse = parse;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

