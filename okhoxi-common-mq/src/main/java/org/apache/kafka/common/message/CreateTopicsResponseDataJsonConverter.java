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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreateTopicsResponseData.*;

public class CreateTopicsResponseDataJsonConverter {
    public static CreateTopicsResponseData read(JsonNode _node, short _version) {
        CreateTopicsResponseData _object = new CreateTopicsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 2) {
                throw new RuntimeException("CreateTopicsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "CreateTopicsResponseData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("CreateTopicsResponseData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("CreateTopicsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            CreatableTopicResultCollection _collection = new CreatableTopicResultCollection(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(CreatableTopicResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(CreateTopicsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 2) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (CreatableTopicResult _element : _object.topics) {
            _topicsArray.add(CreatableTopicResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(CreateTopicsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class CreatableTopicConfigsJsonConverter {
        public static CreatableTopicConfigs read(JsonNode _node, short _version) {
            CreatableTopicConfigs _object = new CreatableTopicConfigs();
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatableTopicConfigs");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("CreatableTopicConfigs: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("CreatableTopicConfigs expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("CreatableTopicConfigs: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                if (_valueNode.isNull()) {
                    _object.value = null;
                } else {
                    if (!_valueNode.isTextual()) {
                        throw new RuntimeException("CreatableTopicConfigs expected a string type, but got " + _node.getNodeType());
                    }
                    _object.value = _valueNode.asText();
                }
            }
            JsonNode _readOnlyNode = _node.get("readOnly");
            if (_readOnlyNode == null) {
                throw new RuntimeException("CreatableTopicConfigs: unable to locate field 'readOnly', which is mandatory in version " + _version);
            } else {
                if (!_readOnlyNode.isBoolean()) {
                    throw new RuntimeException("CreatableTopicConfigs expected Boolean type, but got " + _node.getNodeType());
                }
                _object.readOnly = _readOnlyNode.asBoolean();
            }
            JsonNode _configSourceNode = _node.get("configSource");
            if (_configSourceNode == null) {
                throw new RuntimeException("CreatableTopicConfigs: unable to locate field 'configSource', which is mandatory in version " + _version);
            } else {
                _object.configSource = MessageUtil.jsonNodeToByte(_configSourceNode, "CreatableTopicConfigs");
            }
            JsonNode _isSensitiveNode = _node.get("isSensitive");
            if (_isSensitiveNode == null) {
                throw new RuntimeException("CreatableTopicConfigs: unable to locate field 'isSensitive', which is mandatory in version " + _version);
            } else {
                if (!_isSensitiveNode.isBoolean()) {
                    throw new RuntimeException("CreatableTopicConfigs expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isSensitive = _isSensitiveNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(CreatableTopicConfigs _object, short _version, boolean _serializeRecords) {
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of CreatableTopicConfigs");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            if (_object.value == null) {
                _node.set("value", NullNode.instance);
            } else {
                _node.set("value", new TextNode(_object.value));
            }
            _node.set("readOnly", BooleanNode.valueOf(_object.readOnly));
            _node.set("configSource", new ShortNode(_object.configSource));
            _node.set("isSensitive", BooleanNode.valueOf(_object.isSensitive));
            return _node;
        }
        public static JsonNode write(CreatableTopicConfigs _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class CreatableTopicResultJsonConverter {
        public static CreatableTopicResult read(JsonNode _node, short _version) {
            CreatableTopicResult _object = new CreatableTopicResult();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("CreatableTopicResult: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("CreatableTopicResult expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 7) {
                    throw new RuntimeException("CreatableTopicResult: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("CreatableTopicResult expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("CreatableTopicResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "CreatableTopicResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("CreatableTopicResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
                } else {
                    _object.errorMessage = "";
                }
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("CreatableTopicResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            JsonNode _topicConfigErrorCodeNode = _node.get("topicConfigErrorCode");
            if (_topicConfigErrorCodeNode == null) {
                _object.topicConfigErrorCode = (short) 0;
            } else {
                _object.topicConfigErrorCode = MessageUtil.jsonNodeToShort(_topicConfigErrorCodeNode, "CreatableTopicResult");
            }
            JsonNode _numPartitionsNode = _node.get("numPartitions");
            if (_numPartitionsNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("CreatableTopicResult: unable to locate field 'numPartitions', which is mandatory in version " + _version);
                } else {
                    _object.numPartitions = -1;
                }
            } else {
                _object.numPartitions = MessageUtil.jsonNodeToInt(_numPartitionsNode, "CreatableTopicResult");
            }
            JsonNode _replicationFactorNode = _node.get("replicationFactor");
            if (_replicationFactorNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("CreatableTopicResult: unable to locate field 'replicationFactor', which is mandatory in version " + _version);
                } else {
                    _object.replicationFactor = (short) -1;
                }
            } else {
                _object.replicationFactor = MessageUtil.jsonNodeToShort(_replicationFactorNode, "CreatableTopicResult");
            }
            JsonNode _configsNode = _node.get("configs");
            if (_configsNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("CreatableTopicResult: unable to locate field 'configs', which is mandatory in version " + _version);
                } else {
                    _object.configs = new ArrayList<CreatableTopicConfigs>(0);
                }
            } else {
                if (_configsNode.isNull()) {
                    _object.configs = null;
                } else {
                    if (!_configsNode.isArray()) {
                        throw new RuntimeException("CreatableTopicResult expected a JSON array, but got " + _node.getNodeType());
                    }
                    ArrayList<CreatableTopicConfigs> _collection = new ArrayList<CreatableTopicConfigs>(_configsNode.size());
                    _object.configs = _collection;
                    for (JsonNode _element : _configsNode) {
                        _collection.add(CreatableTopicConfigsJsonConverter.read(_element, _version));
                    }
                }
            }
            return _object;
        }
        public static JsonNode write(CreatableTopicResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            if (_version >= 7) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_version >= 1) {
                if (_object.errorMessage == null) {
                    _node.set("errorMessage", NullNode.instance);
                } else {
                    _node.set("errorMessage", new TextNode(_object.errorMessage));
                }
            }
            if (_version >= 5) {
                if (_object.topicConfigErrorCode != (short) 0) {
                    _node.set("topicConfigErrorCode", new ShortNode(_object.topicConfigErrorCode));
                }
            }
            if (_version >= 5) {
                _node.set("numPartitions", new IntNode(_object.numPartitions));
            }
            if (_version >= 5) {
                _node.set("replicationFactor", new ShortNode(_object.replicationFactor));
            }
            if (_version >= 5) {
                if (_object.configs == null) {
                    _node.set("configs", NullNode.instance);
                } else {
                    ArrayNode _configsArray = new ArrayNode(JsonNodeFactory.instance);
                    for (CreatableTopicConfigs _element : _object.configs) {
                        _configsArray.add(CreatableTopicConfigsJsonConverter.write(_element, _version, _serializeRecords));
                    }
                    _node.set("configs", _configsArray);
                }
            }
            return _node;
        }
        public static JsonNode write(CreatableTopicResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
