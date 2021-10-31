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
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ApiVersionsResponseData.*;

public class ApiVersionsResponseDataJsonConverter {
    public static ApiVersionsResponseData read(JsonNode _node, short _version) {
        ApiVersionsResponseData _object = new ApiVersionsResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("ApiVersionsResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "ApiVersionsResponseData");
        }
        JsonNode _apiKeysNode = _node.get("apiKeys");
        if (_apiKeysNode == null) {
            throw new RuntimeException("ApiVersionsResponseData: unable to locate field 'apiKeys', which is mandatory in version " + _version);
        } else {
            if (!_apiKeysNode.isArray()) {
                throw new RuntimeException("ApiVersionsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ApiVersionCollection _collection = new ApiVersionCollection(_apiKeysNode.size());
            _object.apiKeys = _collection;
            for (JsonNode _element : _apiKeysNode) {
                _collection.add(ApiVersionJsonConverter.read(_element, _version));
            }
        }
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("ApiVersionsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "ApiVersionsResponseData");
        }
        JsonNode _supportedFeaturesNode = _node.get("supportedFeatures");
        if (_supportedFeaturesNode == null) {
            _object.supportedFeatures = new SupportedFeatureKeyCollection(0);
        } else {
            if (!_supportedFeaturesNode.isArray()) {
                throw new RuntimeException("ApiVersionsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            SupportedFeatureKeyCollection _collection = new SupportedFeatureKeyCollection(_supportedFeaturesNode.size());
            _object.supportedFeatures = _collection;
            for (JsonNode _element : _supportedFeaturesNode) {
                _collection.add(SupportedFeatureKeyJsonConverter.read(_element, _version));
            }
        }
        JsonNode _finalizedFeaturesEpochNode = _node.get("finalizedFeaturesEpoch");
        if (_finalizedFeaturesEpochNode == null) {
            _object.finalizedFeaturesEpoch = -1L;
        } else {
            _object.finalizedFeaturesEpoch = MessageUtil.jsonNodeToLong(_finalizedFeaturesEpochNode, "ApiVersionsResponseData");
        }
        JsonNode _finalizedFeaturesNode = _node.get("finalizedFeatures");
        if (_finalizedFeaturesNode == null) {
            _object.finalizedFeatures = new FinalizedFeatureKeyCollection(0);
        } else {
            if (!_finalizedFeaturesNode.isArray()) {
                throw new RuntimeException("ApiVersionsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            FinalizedFeatureKeyCollection _collection = new FinalizedFeatureKeyCollection(_finalizedFeaturesNode.size());
            _object.finalizedFeatures = _collection;
            for (JsonNode _element : _finalizedFeaturesNode) {
                _collection.add(FinalizedFeatureKeyJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ApiVersionsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _apiKeysArray = new ArrayNode(JsonNodeFactory.instance);
        for (ApiVersion _element : _object.apiKeys) {
            _apiKeysArray.add(ApiVersionJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("apiKeys", _apiKeysArray);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        if (_version >= 3) {
            if (!_object.supportedFeatures.isEmpty()) {
                ArrayNode _supportedFeaturesArray = new ArrayNode(JsonNodeFactory.instance);
                for (SupportedFeatureKey _element : _object.supportedFeatures) {
                    _supportedFeaturesArray.add(SupportedFeatureKeyJsonConverter.write(_element, _version, _serializeRecords));
                }
                _node.set("supportedFeatures", _supportedFeaturesArray);
            }
        } else {
            if (!_object.supportedFeatures.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default supportedFeatures at version " + _version);
            }
        }
        if (_version >= 3) {
            if (_object.finalizedFeaturesEpoch != -1L) {
                _node.set("finalizedFeaturesEpoch", new LongNode(_object.finalizedFeaturesEpoch));
            }
        }
        if (_version >= 3) {
            if (!_object.finalizedFeatures.isEmpty()) {
                ArrayNode _finalizedFeaturesArray = new ArrayNode(JsonNodeFactory.instance);
                for (FinalizedFeatureKey _element : _object.finalizedFeatures) {
                    _finalizedFeaturesArray.add(FinalizedFeatureKeyJsonConverter.write(_element, _version, _serializeRecords));
                }
                _node.set("finalizedFeatures", _finalizedFeaturesArray);
            }
        } else {
            if (!_object.finalizedFeatures.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default finalizedFeatures at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(ApiVersionsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ApiVersionJsonConverter {
        public static ApiVersion read(JsonNode _node, short _version) {
            ApiVersion _object = new ApiVersion();
            JsonNode _apiKeyNode = _node.get("apiKey");
            if (_apiKeyNode == null) {
                throw new RuntimeException("ApiVersion: unable to locate field 'apiKey', which is mandatory in version " + _version);
            } else {
                _object.apiKey = MessageUtil.jsonNodeToShort(_apiKeyNode, "ApiVersion");
            }
            JsonNode _minVersionNode = _node.get("minVersion");
            if (_minVersionNode == null) {
                throw new RuntimeException("ApiVersion: unable to locate field 'minVersion', which is mandatory in version " + _version);
            } else {
                _object.minVersion = MessageUtil.jsonNodeToShort(_minVersionNode, "ApiVersion");
            }
            JsonNode _maxVersionNode = _node.get("maxVersion");
            if (_maxVersionNode == null) {
                throw new RuntimeException("ApiVersion: unable to locate field 'maxVersion', which is mandatory in version " + _version);
            } else {
                _object.maxVersion = MessageUtil.jsonNodeToShort(_maxVersionNode, "ApiVersion");
            }
            return _object;
        }
        public static JsonNode write(ApiVersion _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("apiKey", new ShortNode(_object.apiKey));
            _node.set("minVersion", new ShortNode(_object.minVersion));
            _node.set("maxVersion", new ShortNode(_object.maxVersion));
            return _node;
        }
        public static JsonNode write(ApiVersion _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class FinalizedFeatureKeyJsonConverter {
        public static FinalizedFeatureKey read(JsonNode _node, short _version) {
            FinalizedFeatureKey _object = new FinalizedFeatureKey();
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of FinalizedFeatureKey");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("FinalizedFeatureKey: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("FinalizedFeatureKey expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _maxVersionLevelNode = _node.get("maxVersionLevel");
            if (_maxVersionLevelNode == null) {
                throw new RuntimeException("FinalizedFeatureKey: unable to locate field 'maxVersionLevel', which is mandatory in version " + _version);
            } else {
                _object.maxVersionLevel = MessageUtil.jsonNodeToShort(_maxVersionLevelNode, "FinalizedFeatureKey");
            }
            JsonNode _minVersionLevelNode = _node.get("minVersionLevel");
            if (_minVersionLevelNode == null) {
                throw new RuntimeException("FinalizedFeatureKey: unable to locate field 'minVersionLevel', which is mandatory in version " + _version);
            } else {
                _object.minVersionLevel = MessageUtil.jsonNodeToShort(_minVersionLevelNode, "FinalizedFeatureKey");
            }
            return _object;
        }
        public static JsonNode write(FinalizedFeatureKey _object, short _version, boolean _serializeRecords) {
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of FinalizedFeatureKey");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("maxVersionLevel", new ShortNode(_object.maxVersionLevel));
            _node.set("minVersionLevel", new ShortNode(_object.minVersionLevel));
            return _node;
        }
        public static JsonNode write(FinalizedFeatureKey _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class SupportedFeatureKeyJsonConverter {
        public static SupportedFeatureKey read(JsonNode _node, short _version) {
            SupportedFeatureKey _object = new SupportedFeatureKey();
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of SupportedFeatureKey");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("SupportedFeatureKey: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("SupportedFeatureKey expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _minVersionNode = _node.get("minVersion");
            if (_minVersionNode == null) {
                throw new RuntimeException("SupportedFeatureKey: unable to locate field 'minVersion', which is mandatory in version " + _version);
            } else {
                _object.minVersion = MessageUtil.jsonNodeToShort(_minVersionNode, "SupportedFeatureKey");
            }
            JsonNode _maxVersionNode = _node.get("maxVersion");
            if (_maxVersionNode == null) {
                throw new RuntimeException("SupportedFeatureKey: unable to locate field 'maxVersion', which is mandatory in version " + _version);
            } else {
                _object.maxVersion = MessageUtil.jsonNodeToShort(_maxVersionNode, "SupportedFeatureKey");
            }
            return _object;
        }
        public static JsonNode write(SupportedFeatureKey _object, short _version, boolean _serializeRecords) {
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of SupportedFeatureKey");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("minVersion", new ShortNode(_object.minVersion));
            _node.set("maxVersion", new ShortNode(_object.maxVersion));
            return _node;
        }
        public static JsonNode write(SupportedFeatureKey _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
