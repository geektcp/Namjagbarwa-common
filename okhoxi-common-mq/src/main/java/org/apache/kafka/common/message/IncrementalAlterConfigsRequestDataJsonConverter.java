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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.IncrementalAlterConfigsRequestData.*;

public class IncrementalAlterConfigsRequestDataJsonConverter {
    public static IncrementalAlterConfigsRequestData read(JsonNode _node, short _version) {
        IncrementalAlterConfigsRequestData _object = new IncrementalAlterConfigsRequestData();
        JsonNode _resourcesNode = _node.get("resources");
        if (_resourcesNode == null) {
            throw new RuntimeException("IncrementalAlterConfigsRequestData: unable to locate field 'resources', which is mandatory in version " + _version);
        } else {
            if (!_resourcesNode.isArray()) {
                throw new RuntimeException("IncrementalAlterConfigsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            AlterConfigsResourceCollection _collection = new AlterConfigsResourceCollection(_resourcesNode.size());
            _object.resources = _collection;
            for (JsonNode _element : _resourcesNode) {
                _collection.add(AlterConfigsResourceJsonConverter.read(_element, _version));
            }
        }
        JsonNode _validateOnlyNode = _node.get("validateOnly");
        if (_validateOnlyNode == null) {
            throw new RuntimeException("IncrementalAlterConfigsRequestData: unable to locate field 'validateOnly', which is mandatory in version " + _version);
        } else {
            if (!_validateOnlyNode.isBoolean()) {
                throw new RuntimeException("IncrementalAlterConfigsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.validateOnly = _validateOnlyNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(IncrementalAlterConfigsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _resourcesArray = new ArrayNode(JsonNodeFactory.instance);
        for (AlterConfigsResource _element : _object.resources) {
            _resourcesArray.add(AlterConfigsResourceJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("resources", _resourcesArray);
        _node.set("validateOnly", BooleanNode.valueOf(_object.validateOnly));
        return _node;
    }
    public static JsonNode write(IncrementalAlterConfigsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AlterConfigsResourceJsonConverter {
        public static AlterConfigsResource read(JsonNode _node, short _version) {
            AlterConfigsResource _object = new AlterConfigsResource();
            JsonNode _resourceTypeNode = _node.get("resourceType");
            if (_resourceTypeNode == null) {
                throw new RuntimeException("AlterConfigsResource: unable to locate field 'resourceType', which is mandatory in version " + _version);
            } else {
                _object.resourceType = MessageUtil.jsonNodeToByte(_resourceTypeNode, "AlterConfigsResource");
            }
            JsonNode _resourceNameNode = _node.get("resourceName");
            if (_resourceNameNode == null) {
                throw new RuntimeException("AlterConfigsResource: unable to locate field 'resourceName', which is mandatory in version " + _version);
            } else {
                if (!_resourceNameNode.isTextual()) {
                    throw new RuntimeException("AlterConfigsResource expected a string type, but got " + _node.getNodeType());
                }
                _object.resourceName = _resourceNameNode.asText();
            }
            JsonNode _configsNode = _node.get("configs");
            if (_configsNode == null) {
                throw new RuntimeException("AlterConfigsResource: unable to locate field 'configs', which is mandatory in version " + _version);
            } else {
                if (!_configsNode.isArray()) {
                    throw new RuntimeException("AlterConfigsResource expected a JSON array, but got " + _node.getNodeType());
                }
                AlterableConfigCollection _collection = new AlterableConfigCollection(_configsNode.size());
                _object.configs = _collection;
                for (JsonNode _element : _configsNode) {
                    _collection.add(AlterableConfigJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(AlterConfigsResource _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("resourceType", new ShortNode(_object.resourceType));
            _node.set("resourceName", new TextNode(_object.resourceName));
            ArrayNode _configsArray = new ArrayNode(JsonNodeFactory.instance);
            for (AlterableConfig _element : _object.configs) {
                _configsArray.add(AlterableConfigJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("configs", _configsArray);
            return _node;
        }
        public static JsonNode write(AlterConfigsResource _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class AlterableConfigJsonConverter {
        public static AlterableConfig read(JsonNode _node, short _version) {
            AlterableConfig _object = new AlterableConfig();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("AlterableConfig: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("AlterableConfig expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _configOperationNode = _node.get("configOperation");
            if (_configOperationNode == null) {
                throw new RuntimeException("AlterableConfig: unable to locate field 'configOperation', which is mandatory in version " + _version);
            } else {
                _object.configOperation = MessageUtil.jsonNodeToByte(_configOperationNode, "AlterableConfig");
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("AlterableConfig: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                if (_valueNode.isNull()) {
                    _object.value = null;
                } else {
                    if (!_valueNode.isTextual()) {
                        throw new RuntimeException("AlterableConfig expected a string type, but got " + _node.getNodeType());
                    }
                    _object.value = _valueNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(AlterableConfig _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("configOperation", new ShortNode(_object.configOperation));
            if (_object.value == null) {
                _node.set("value", NullNode.instance);
            } else {
                _node.set("value", new TextNode(_object.value));
            }
            return _node;
        }
        public static JsonNode write(AlterableConfig _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
