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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DeleteTopicsResponseData.*;

public class DeleteTopicsResponseDataJsonConverter {
    public static DeleteTopicsResponseData read(JsonNode _node, short _version) {
        DeleteTopicsResponseData _object = new DeleteTopicsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("DeleteTopicsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DeleteTopicsResponseData");
        }
        JsonNode _responsesNode = _node.get("responses");
        if (_responsesNode == null) {
            throw new RuntimeException("DeleteTopicsResponseData: unable to locate field 'responses', which is mandatory in version " + _version);
        } else {
            if (!_responsesNode.isArray()) {
                throw new RuntimeException("DeleteTopicsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            DeletableTopicResultCollection _collection = new DeletableTopicResultCollection(_responsesNode.size());
            _object.responses = _collection;
            for (JsonNode _element : _responsesNode) {
                _collection.add(DeletableTopicResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DeleteTopicsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        ArrayNode _responsesArray = new ArrayNode(JsonNodeFactory.instance);
        for (DeletableTopicResult _element : _object.responses) {
            _responsesArray.add(DeletableTopicResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("responses", _responsesArray);
        return _node;
    }
    public static JsonNode write(DeleteTopicsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DeletableTopicResultJsonConverter {
        public static DeletableTopicResult read(JsonNode _node, short _version) {
            DeletableTopicResult _object = new DeletableTopicResult();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DeletableTopicResult: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (_nameNode.isNull()) {
                    _object.name = null;
                } else {
                    if (!_nameNode.isTextual()) {
                        throw new RuntimeException("DeletableTopicResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.name = _nameNode.asText();
                }
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 6) {
                    throw new RuntimeException("DeletableTopicResult: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("DeletableTopicResult expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DeletableTopicResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DeletableTopicResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("DeletableTopicResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
                } else {
                    _object.errorMessage = null;
                }
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("DeletableTopicResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(DeletableTopicResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_object.name == null) {
                _node.set("name", NullNode.instance);
            } else {
                _node.set("name", new TextNode(_object.name));
            }
            if (_version >= 6) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_version >= 5) {
                if (_object.errorMessage == null) {
                    _node.set("errorMessage", NullNode.instance);
                } else {
                    _node.set("errorMessage", new TextNode(_object.errorMessage));
                }
            }
            return _node;
        }
        public static JsonNode write(DeletableTopicResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
