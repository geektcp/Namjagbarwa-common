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
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeConfigsResponseData.*;

public class DescribeConfigsResponseDataJsonConverter {
    public static DescribeConfigsResponseData read(JsonNode _node, short _version) {
        DescribeConfigsResponseData _object = new DescribeConfigsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeConfigsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeConfigsResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("DescribeConfigsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("DescribeConfigsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribeConfigsResult> _collection = new ArrayList<DescribeConfigsResult>(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(DescribeConfigsResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeConfigsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeConfigsResult _element : _object.results) {
            _resultsArray.add(DescribeConfigsResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(DescribeConfigsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribeConfigsResourceResultJsonConverter {
        public static DescribeConfigsResourceResult read(JsonNode _node, short _version) {
            DescribeConfigsResourceResult _object = new DescribeConfigsResourceResult();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("DescribeConfigsResourceResult expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                if (_valueNode.isNull()) {
                    _object.value = null;
                } else {
                    if (!_valueNode.isTextual()) {
                        throw new RuntimeException("DescribeConfigsResourceResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.value = _valueNode.asText();
                }
            }
            JsonNode _readOnlyNode = _node.get("readOnly");
            if (_readOnlyNode == null) {
                throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'readOnly', which is mandatory in version " + _version);
            } else {
                if (!_readOnlyNode.isBoolean()) {
                    throw new RuntimeException("DescribeConfigsResourceResult expected Boolean type, but got " + _node.getNodeType());
                }
                _object.readOnly = _readOnlyNode.asBoolean();
            }
            JsonNode _isDefaultNode = _node.get("isDefault");
            if (_isDefaultNode == null) {
                if (_version <= 0) {
                    throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'isDefault', which is mandatory in version " + _version);
                } else {
                    _object.isDefault = false;
                }
            } else {
                if (!_isDefaultNode.isBoolean()) {
                    throw new RuntimeException("DescribeConfigsResourceResult expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isDefault = _isDefaultNode.asBoolean();
            }
            JsonNode _configSourceNode = _node.get("configSource");
            if (_configSourceNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'configSource', which is mandatory in version " + _version);
                } else {
                    _object.configSource = (byte) -1;
                }
            } else {
                _object.configSource = MessageUtil.jsonNodeToByte(_configSourceNode, "DescribeConfigsResourceResult");
            }
            JsonNode _isSensitiveNode = _node.get("isSensitive");
            if (_isSensitiveNode == null) {
                throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'isSensitive', which is mandatory in version " + _version);
            } else {
                if (!_isSensitiveNode.isBoolean()) {
                    throw new RuntimeException("DescribeConfigsResourceResult expected Boolean type, but got " + _node.getNodeType());
                }
                _object.isSensitive = _isSensitiveNode.asBoolean();
            }
            JsonNode _synonymsNode = _node.get("synonyms");
            if (_synonymsNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'synonyms', which is mandatory in version " + _version);
                } else {
                    _object.synonyms = new ArrayList<DescribeConfigsSynonym>(0);
                }
            } else {
                if (!_synonymsNode.isArray()) {
                    throw new RuntimeException("DescribeConfigsResourceResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribeConfigsSynonym> _collection = new ArrayList<DescribeConfigsSynonym>(_synonymsNode.size());
                _object.synonyms = _collection;
                for (JsonNode _element : _synonymsNode) {
                    _collection.add(DescribeConfigsSynonymJsonConverter.read(_element, _version));
                }
            }
            JsonNode _configTypeNode = _node.get("configType");
            if (_configTypeNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'configType', which is mandatory in version " + _version);
                } else {
                    _object.configType = (byte) 0;
                }
            } else {
                _object.configType = MessageUtil.jsonNodeToByte(_configTypeNode, "DescribeConfigsResourceResult");
            }
            JsonNode _documentationNode = _node.get("documentation");
            if (_documentationNode == null) {
                if (_version >= 3) {
                    throw new RuntimeException("DescribeConfigsResourceResult: unable to locate field 'documentation', which is mandatory in version " + _version);
                } else {
                    _object.documentation = "";
                }
            } else {
                if (_documentationNode.isNull()) {
                    _object.documentation = null;
                } else {
                    if (!_documentationNode.isTextual()) {
                        throw new RuntimeException("DescribeConfigsResourceResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.documentation = _documentationNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeConfigsResourceResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            if (_object.value == null) {
                _node.set("value", NullNode.instance);
            } else {
                _node.set("value", new TextNode(_object.value));
            }
            _node.set("readOnly", BooleanNode.valueOf(_object.readOnly));
            if (_version <= 0) {
                _node.set("isDefault", BooleanNode.valueOf(_object.isDefault));
            } else {
                if (_object.isDefault) {
                    throw new UnsupportedVersionException("Attempted to write a non-default isDefault at version " + _version);
                }
            }
            if (_version >= 1) {
                _node.set("configSource", new ShortNode(_object.configSource));
            }
            _node.set("isSensitive", BooleanNode.valueOf(_object.isSensitive));
            if (_version >= 1) {
                ArrayNode _synonymsArray = new ArrayNode(JsonNodeFactory.instance);
                for (DescribeConfigsSynonym _element : _object.synonyms) {
                    _synonymsArray.add(DescribeConfigsSynonymJsonConverter.write(_element, _version, _serializeRecords));
                }
                _node.set("synonyms", _synonymsArray);
            }
            if (_version >= 3) {
                _node.set("configType", new ShortNode(_object.configType));
            }
            if (_version >= 3) {
                if (_object.documentation == null) {
                    _node.set("documentation", NullNode.instance);
                } else {
                    _node.set("documentation", new TextNode(_object.documentation));
                }
            }
            return _node;
        }
        public static JsonNode write(DescribeConfigsResourceResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeConfigsResultJsonConverter {
        public static DescribeConfigsResult read(JsonNode _node, short _version) {
            DescribeConfigsResult _object = new DescribeConfigsResult();
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DescribeConfigsResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeConfigsResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                throw new RuntimeException("DescribeConfigsResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("DescribeConfigsResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            JsonNode _resourceTypeNode = _node.get("resourceType");
            if (_resourceTypeNode == null) {
                throw new RuntimeException("DescribeConfigsResult: unable to locate field 'resourceType', which is mandatory in version " + _version);
            } else {
                _object.resourceType = MessageUtil.jsonNodeToByte(_resourceTypeNode, "DescribeConfigsResult");
            }
            JsonNode _resourceNameNode = _node.get("resourceName");
            if (_resourceNameNode == null) {
                throw new RuntimeException("DescribeConfigsResult: unable to locate field 'resourceName', which is mandatory in version " + _version);
            } else {
                if (!_resourceNameNode.isTextual()) {
                    throw new RuntimeException("DescribeConfigsResult expected a string type, but got " + _node.getNodeType());
                }
                _object.resourceName = _resourceNameNode.asText();
            }
            JsonNode _configsNode = _node.get("configs");
            if (_configsNode == null) {
                throw new RuntimeException("DescribeConfigsResult: unable to locate field 'configs', which is mandatory in version " + _version);
            } else {
                if (!_configsNode.isArray()) {
                    throw new RuntimeException("DescribeConfigsResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribeConfigsResourceResult> _collection = new ArrayList<DescribeConfigsResourceResult>(_configsNode.size());
                _object.configs = _collection;
                for (JsonNode _element : _configsNode) {
                    _collection.add(DescribeConfigsResourceResultJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeConfigsResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
            _node.set("resourceType", new ShortNode(_object.resourceType));
            _node.set("resourceName", new TextNode(_object.resourceName));
            ArrayNode _configsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribeConfigsResourceResult _element : _object.configs) {
                _configsArray.add(DescribeConfigsResourceResultJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("configs", _configsArray);
            return _node;
        }
        public static JsonNode write(DescribeConfigsResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeConfigsSynonymJsonConverter {
        public static DescribeConfigsSynonym read(JsonNode _node, short _version) {
            DescribeConfigsSynonym _object = new DescribeConfigsSynonym();
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeConfigsSynonym");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DescribeConfigsSynonym: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("DescribeConfigsSynonym expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("DescribeConfigsSynonym: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                if (_valueNode.isNull()) {
                    _object.value = null;
                } else {
                    if (!_valueNode.isTextual()) {
                        throw new RuntimeException("DescribeConfigsSynonym expected a string type, but got " + _node.getNodeType());
                    }
                    _object.value = _valueNode.asText();
                }
            }
            JsonNode _sourceNode = _node.get("source");
            if (_sourceNode == null) {
                throw new RuntimeException("DescribeConfigsSynonym: unable to locate field 'source', which is mandatory in version " + _version);
            } else {
                _object.source = MessageUtil.jsonNodeToByte(_sourceNode, "DescribeConfigsSynonym");
            }
            return _object;
        }
        public static JsonNode write(DescribeConfigsSynonym _object, short _version, boolean _serializeRecords) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of DescribeConfigsSynonym");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            if (_object.value == null) {
                _node.set("value", NullNode.instance);
            } else {
                _node.set("value", new TextNode(_object.value));
            }
            _node.set("source", new ShortNode(_object.source));
            return _node;
        }
        public static JsonNode write(DescribeConfigsSynonym _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
