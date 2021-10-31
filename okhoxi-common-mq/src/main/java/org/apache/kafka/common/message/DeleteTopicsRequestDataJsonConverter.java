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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DeleteTopicsRequestData.*;

public class DeleteTopicsRequestDataJsonConverter {
    public static DeleteTopicsRequestData read(JsonNode _node, short _version) {
        DeleteTopicsRequestData _object = new DeleteTopicsRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            if (_version >= 6) {
                throw new RuntimeException("DeleteTopicsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                _object.topics = new ArrayList<DeleteTopicState>(0);
            }
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("DeleteTopicsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DeleteTopicState> _collection = new ArrayList<DeleteTopicState>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(DeleteTopicStateJsonConverter.read(_element, _version));
            }
        }
        JsonNode _topicNamesNode = _node.get("topicNames");
        if (_topicNamesNode == null) {
            if (_version <= 5) {
                throw new RuntimeException("DeleteTopicsRequestData: unable to locate field 'topicNames', which is mandatory in version " + _version);
            } else {
                _object.topicNames = new ArrayList<String>(0);
            }
        } else {
            if (!_topicNamesNode.isArray()) {
                throw new RuntimeException("DeleteTopicsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<String> _collection = new ArrayList<String>(_topicNamesNode.size());
            _object.topicNames = _collection;
            for (JsonNode _element : _topicNamesNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("DeleteTopicsRequestData element expected a string type, but got " + _node.getNodeType());
                }
                _collection.add(_element.asText());
            }
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("DeleteTopicsRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "DeleteTopicsRequestData");
        }
        return _object;
    }
    public static JsonNode write(DeleteTopicsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 6) {
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DeleteTopicState _element : _object.topics) {
                _topicsArray.add(DeleteTopicStateJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
        } else {
            if (!_object.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
            }
        }
        if (_version <= 5) {
            ArrayNode _topicNamesArray = new ArrayNode(JsonNodeFactory.instance);
            for (String _element : _object.topicNames) {
                _topicNamesArray.add(new TextNode(_element));
            }
            _node.set("topicNames", _topicNamesArray);
        }
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        return _node;
    }
    public static JsonNode write(DeleteTopicsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DeleteTopicStateJsonConverter {
        public static DeleteTopicState read(JsonNode _node, short _version) {
            DeleteTopicState _object = new DeleteTopicState();
            if (_version < 6) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DeleteTopicState");
            }
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("DeleteTopicState: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (_nameNode.isNull()) {
                    _object.name = null;
                } else {
                    if (!_nameNode.isTextual()) {
                        throw new RuntimeException("DeleteTopicState expected a string type, but got " + _node.getNodeType());
                    }
                    _object.name = _nameNode.asText();
                }
            }
            JsonNode _topicIdNode = _node.get("topicId");
            if (_topicIdNode == null) {
                throw new RuntimeException("DeleteTopicState: unable to locate field 'topicId', which is mandatory in version " + _version);
            } else {
                if (!_topicIdNode.isTextual()) {
                    throw new RuntimeException("DeleteTopicState expected a JSON string type, but got " + _node.getNodeType());
                }
                _object.topicId = Uuid.fromString(_topicIdNode.asText());
            }
            return _object;
        }
        public static JsonNode write(DeleteTopicState _object, short _version, boolean _serializeRecords) {
            if (_version < 6) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of DeleteTopicState");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            if (_object.name == null) {
                _node.set("name", NullNode.instance);
            } else {
                _node.set("name", new TextNode(_object.name));
            }
            _node.set("topicId", new TextNode(_object.topicId.toString()));
            return _node;
        }
        public static JsonNode write(DeleteTopicState _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
