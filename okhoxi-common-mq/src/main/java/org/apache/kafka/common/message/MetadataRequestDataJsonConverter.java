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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;

import static org.apache.kafka.common.message.MetadataRequestData.*;

public class MetadataRequestDataJsonConverter {
    public static MetadataRequestData read(JsonNode _node, short _version) {
        MetadataRequestData _object = new MetadataRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("MetadataRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (_topicsNode.isNull()) {
                _object.topics = null;
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("MetadataRequestData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<MetadataRequestTopic> _collection = new ArrayList<MetadataRequestTopic>(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(MetadataRequestTopicJsonConverter.read(_element, _version));
                }
            }
        }
        JsonNode _allowAutoTopicCreationNode = _node.get("allowAutoTopicCreation");
        if (_allowAutoTopicCreationNode == null) {
            if (_version >= 4) {
                throw new RuntimeException("MetadataRequestData: unable to locate field 'allowAutoTopicCreation', which is mandatory in version " + _version);
            } else {
                _object.allowAutoTopicCreation = true;
            }
        } else {
            if (!_allowAutoTopicCreationNode.isBoolean()) {
                throw new RuntimeException("MetadataRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.allowAutoTopicCreation = _allowAutoTopicCreationNode.asBoolean();
        }
        JsonNode _includeClusterAuthorizedOperationsNode = _node.get("includeClusterAuthorizedOperations");
        if (_includeClusterAuthorizedOperationsNode == null) {
            if ((_version >= 8) && (_version <= 10)) {
                throw new RuntimeException("MetadataRequestData: unable to locate field 'includeClusterAuthorizedOperations', which is mandatory in version " + _version);
            } else {
                _object.includeClusterAuthorizedOperations = false;
            }
        } else {
            if (!_includeClusterAuthorizedOperationsNode.isBoolean()) {
                throw new RuntimeException("MetadataRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.includeClusterAuthorizedOperations = _includeClusterAuthorizedOperationsNode.asBoolean();
        }
        JsonNode _includeTopicAuthorizedOperationsNode = _node.get("includeTopicAuthorizedOperations");
        if (_includeTopicAuthorizedOperationsNode == null) {
            if (_version >= 8) {
                throw new RuntimeException("MetadataRequestData: unable to locate field 'includeTopicAuthorizedOperations', which is mandatory in version " + _version);
            } else {
                _object.includeTopicAuthorizedOperations = false;
            }
        } else {
            if (!_includeTopicAuthorizedOperationsNode.isBoolean()) {
                throw new RuntimeException("MetadataRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.includeTopicAuthorizedOperations = _includeTopicAuthorizedOperationsNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(MetadataRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.topics == null) {
            _node.set("topics", NullNode.instance);
        } else {
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (MetadataRequestTopic _element : _object.topics) {
                _topicsArray.add(MetadataRequestTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
        }
        if (_version >= 4) {
            _node.set("allowAutoTopicCreation", BooleanNode.valueOf(_object.allowAutoTopicCreation));
        } else {
            if (!_object.allowAutoTopicCreation) {
                throw new UnsupportedVersionException("Attempted to write a non-default allowAutoTopicCreation at version " + _version);
            }
        }
        if ((_version >= 8) && (_version <= 10)) {
            _node.set("includeClusterAuthorizedOperations", BooleanNode.valueOf(_object.includeClusterAuthorizedOperations));
        } else {
            if (_object.includeClusterAuthorizedOperations) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeClusterAuthorizedOperations at version " + _version);
            }
        }
        if (_version >= 8) {
            _node.set("includeTopicAuthorizedOperations", BooleanNode.valueOf(_object.includeTopicAuthorizedOperations));
        } else {
            if (_object.includeTopicAuthorizedOperations) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeTopicAuthorizedOperations at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(MetadataRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class MetadataRequestTopicJsonConverter {
        public static MetadataRequestTopic read(JsonNode _node, short _version) {
            MetadataRequestTopic _object = new MetadataRequestTopic();
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                if (_version >= 10) {
                    throw new RuntimeException("MetadataRequestTopic: unable to locate field 'topicId', which is mandatory in version " + _version);
                } else {
                    _object.topicId = Uuid.ZERO_UUID;
                }
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("MetadataRequestTopic expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("MetadataRequestTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (_nameNode.isNull()) {
                    _object.name = null;
                } else {
                    if (!_nameNode.isTextual()) {
                        throw new RuntimeException("MetadataRequestTopic expected a string type, but got " + _node.getNodeType());
                    }
                    _object.name = _nameNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(MetadataRequestTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_version >= 10) {
                _node.set("topicId", new TextNode(_object.topicId.toString()));
            }
            if (_object.name == null) {
                _node.set("name", NullNode.instance);
            } else {
                _node.set("name", new TextNode(_object.name));
            }
            return _node;
        }
        public static JsonNode write(MetadataRequestTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
