/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.UpdateFeaturesRequestData.*;

public class UpdateFeaturesRequestDataJsonConverter {
    public static UpdateFeaturesRequestData read(JsonNode _node, short _version) {
        UpdateFeaturesRequestData _object = new UpdateFeaturesRequestData();
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("UpdateFeaturesRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "UpdateFeaturesRequestData");
        }
        JsonNode _featureUpdatesNode = _node.get("featureUpdates");
        if (_featureUpdatesNode == null) {
            throw new RuntimeException("UpdateFeaturesRequestData: unable to locate field 'featureUpdates', which is mandatory in version " + _version);
        } else {
            if (!_featureUpdatesNode.isArray()) {
                throw new RuntimeException("UpdateFeaturesRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            FeatureUpdateKeyCollection _collection = new FeatureUpdateKeyCollection(_featureUpdatesNode.size());
            _object.featureUpdates = _collection;
            for (JsonNode _element : _featureUpdatesNode) {
                _collection.add(FeatureUpdateKeyJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(UpdateFeaturesRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        ArrayNode _featureUpdatesArray = new ArrayNode(JsonNodeFactory.instance);
        for (FeatureUpdateKey _element : _object.featureUpdates) {
            _featureUpdatesArray.add(FeatureUpdateKeyJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("featureUpdates", _featureUpdatesArray);
        return _node;
    }
    public static JsonNode write(UpdateFeaturesRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class FeatureUpdateKeyJsonConverter {
        public static FeatureUpdateKey read(JsonNode _node, short _version) {
            FeatureUpdateKey _object = new FeatureUpdateKey();
            JsonNode _featureNode = _node.get("feature");
            if (_featureNode == null) {
                throw new RuntimeException("FeatureUpdateKey: unable to locate field 'feature', which is mandatory in version " + _version);
            } else {
                if (!_featureNode.isTextual()) {
                    throw new RuntimeException("FeatureUpdateKey expected a string type, but got " + _node.getNodeType());
                }
                _object.feature = _featureNode.asText();
            }
            JsonNode _maxVersionLevelNode = _node.get("maxVersionLevel");
            if (_maxVersionLevelNode == null) {
                throw new RuntimeException("FeatureUpdateKey: unable to locate field 'maxVersionLevel', which is mandatory in version " + _version);
            } else {
                _object.maxVersionLevel = MessageUtil.jsonNodeToShort(_maxVersionLevelNode, "FeatureUpdateKey");
            }
            JsonNode _allowDowngradeNode = _node.get("allowDowngrade");
            if (_allowDowngradeNode == null) {
                throw new RuntimeException("FeatureUpdateKey: unable to locate field 'allowDowngrade', which is mandatory in version " + _version);
            } else {
                if (!_allowDowngradeNode.isBoolean()) {
                    throw new RuntimeException("FeatureUpdateKey expected Boolean type, but got " + _node.getNodeType());
                }
                _object.allowDowngrade = _allowDowngradeNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(FeatureUpdateKey _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("feature", new TextNode(_object.feature));
            _node.set("maxVersionLevel", new ShortNode(_object.maxVersionLevel));
            _node.set("allowDowngrade", BooleanNode.valueOf(_object.allowDowngrade));
            return _node;
        }
        public static JsonNode write(FeatureUpdateKey _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
