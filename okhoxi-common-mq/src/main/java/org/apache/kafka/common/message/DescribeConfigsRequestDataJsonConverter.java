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
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeConfigsRequestData.*;

public class DescribeConfigsRequestDataJsonConverter {
    public static DescribeConfigsRequestData read(JsonNode _node, short _version) {
        DescribeConfigsRequestData _object = new DescribeConfigsRequestData();
        JsonNode _resourcesNode = _node.get("resources");
        if (_resourcesNode == null) {
            throw new RuntimeException("DescribeConfigsRequestData: unable to locate field 'resources', which is mandatory in version " + _version);
        } else {
            if (!_resourcesNode.isArray()) {
                throw new RuntimeException("DescribeConfigsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribeConfigsResource> _collection = new ArrayList<DescribeConfigsResource>(_resourcesNode.size());
            _object.resources = _collection;
            for (JsonNode _element : _resourcesNode) {
                _collection.add(DescribeConfigsResourceJsonConverter.read(_element, _version));
            }
        }
        JsonNode _includeSynonymsNode = _node.get("includeSynonyms");
        if (_includeSynonymsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("DescribeConfigsRequestData: unable to locate field 'includeSynonyms', which is mandatory in version " + _version);
            } else {
                _object.includeSynonyms = false;
            }
        } else {
            if (!_includeSynonymsNode.isBoolean()) {
                throw new RuntimeException("DescribeConfigsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.includeSynonyms = _includeSynonymsNode.asBoolean();
        }
        JsonNode _includeDocumentationNode = _node.get("includeDocumentation");
        if (_includeDocumentationNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("DescribeConfigsRequestData: unable to locate field 'includeDocumentation', which is mandatory in version " + _version);
            } else {
                _object.includeDocumentation = false;
            }
        } else {
            if (!_includeDocumentationNode.isBoolean()) {
                throw new RuntimeException("DescribeConfigsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.includeDocumentation = _includeDocumentationNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(DescribeConfigsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _resourcesArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeConfigsResource _element : _object.resources) {
            _resourcesArray.add(DescribeConfigsResourceJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("resources", _resourcesArray);
        if (_version >= 1) {
            _node.set("includeSynonyms", BooleanNode.valueOf(_object.includeSynonyms));
        } else {
            if (_object.includeSynonyms) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeSynonyms at version " + _version);
            }
        }
        if (_version >= 3) {
            _node.set("includeDocumentation", BooleanNode.valueOf(_object.includeDocumentation));
        } else {
            if (_object.includeDocumentation) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeDocumentation at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(DescribeConfigsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribeConfigsResourceJsonConverter {
        public static DescribeConfigsResource read(JsonNode _node, short _version) {
            DescribeConfigsResource _object = new DescribeConfigsResource();
            JsonNode _resourceTypeNode = _node.get("resourceType");
            if (_resourceTypeNode == null) {
                throw new RuntimeException("DescribeConfigsResource: unable to locate field 'resourceType', which is mandatory in version " + _version);
            } else {
                _object.resourceType = MessageUtil.jsonNodeToByte(_resourceTypeNode, "DescribeConfigsResource");
            }
            JsonNode _resourceNameNode = _node.get("resourceName");
            if (_resourceNameNode == null) {
                throw new RuntimeException("DescribeConfigsResource: unable to locate field 'resourceName', which is mandatory in version " + _version);
            } else {
                if (!_resourceNameNode.isTextual()) {
                    throw new RuntimeException("DescribeConfigsResource expected a string type, but got " + _node.getNodeType());
                }
                _object.resourceName = _resourceNameNode.asText();
            }
            JsonNode _configurationKeysNode = _node.get("configurationKeys");
            if (_configurationKeysNode == null) {
                throw new RuntimeException("DescribeConfigsResource: unable to locate field 'configurationKeys', which is mandatory in version " + _version);
            } else {
                if (_configurationKeysNode.isNull()) {
                    _object.configurationKeys = null;
                } else {
                    if (!_configurationKeysNode.isArray()) {
                        throw new RuntimeException("DescribeConfigsResource expected a JSON array, but got " + _node.getNodeType());
                    }
                    ArrayList<String> _collection = new ArrayList<String>(_configurationKeysNode.size());
                    _object.configurationKeys = _collection;
                    for (JsonNode _element : _configurationKeysNode) {
                        if (!_element.isTextual()) {
                            throw new RuntimeException("DescribeConfigsResource element expected a string type, but got " + _node.getNodeType());
                        }
                        _collection.add(_element.asText());
                    }
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeConfigsResource _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("resourceType", new ShortNode(_object.resourceType));
            _node.set("resourceName", new TextNode(_object.resourceName));
            if (_object.configurationKeys == null) {
                _node.set("configurationKeys", NullNode.instance);
            } else {
                ArrayNode _configurationKeysArray = new ArrayNode(JsonNodeFactory.instance);
                for (String _element : _object.configurationKeys) {
                    _configurationKeysArray.add(new TextNode(_element));
                }
                _node.set("configurationKeys", _configurationKeysArray);
            }
            return _node;
        }
        public static JsonNode write(DescribeConfigsResource _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
