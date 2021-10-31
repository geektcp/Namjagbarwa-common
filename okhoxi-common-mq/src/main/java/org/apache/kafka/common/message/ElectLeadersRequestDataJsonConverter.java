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
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ElectLeadersRequestData.*;

public class ElectLeadersRequestDataJsonConverter {
    public static ElectLeadersRequestData read(JsonNode _node, short _version) {
        ElectLeadersRequestData _object = new ElectLeadersRequestData();
        JsonNode _electionTypeNode = _node.get("electionType");
        if (_electionTypeNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("ElectLeadersRequestData: unable to locate field 'electionType', which is mandatory in version " + _version);
            } else {
                _object.electionType = (byte) 0;
            }
        } else {
            _object.electionType = MessageUtil.jsonNodeToByte(_electionTypeNode, "ElectLeadersRequestData");
        }
        JsonNode _topicPartitionsNode = _node.get("topicPartitions");
        if (_topicPartitionsNode == null) {
            throw new RuntimeException("ElectLeadersRequestData: unable to locate field 'topicPartitions', which is mandatory in version " + _version);
        } else {
            if (_topicPartitionsNode.isNull()) {
                _object.topicPartitions = null;
            } else {
                if (!_topicPartitionsNode.isArray()) {
                    throw new RuntimeException("ElectLeadersRequestData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<TopicPartitions> _collection = new ArrayList<TopicPartitions>(_topicPartitionsNode.size());
                _object.topicPartitions = _collection;
                for (JsonNode _element : _topicPartitionsNode) {
                    _collection.add(TopicPartitionsJsonConverter.read(_element, _version));
                }
            }
        }
        JsonNode _timeoutMsNode = _node.get("timeoutMs");
        if (_timeoutMsNode == null) {
            throw new RuntimeException("ElectLeadersRequestData: unable to locate field 'timeoutMs', which is mandatory in version " + _version);
        } else {
            _object.timeoutMs = MessageUtil.jsonNodeToInt(_timeoutMsNode, "ElectLeadersRequestData");
        }
        return _object;
    }
    public static JsonNode write(ElectLeadersRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("electionType", new ShortNode(_object.electionType));
        } else {
            if (_object.electionType != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default electionType at version " + _version);
            }
        }
        if (_object.topicPartitions == null) {
            _node.set("topicPartitions", NullNode.instance);
        } else {
            ArrayNode _topicPartitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (TopicPartitions _element : _object.topicPartitions) {
                _topicPartitionsArray.add(TopicPartitionsJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topicPartitions", _topicPartitionsArray);
        }
        _node.set("timeoutMs", new IntNode(_object.timeoutMs));
        return _node;
    }
    public static JsonNode write(ElectLeadersRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class TopicPartitionsJsonConverter {
        public static TopicPartitions read(JsonNode _node, short _version) {
            TopicPartitions _object = new TopicPartitions();
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("TopicPartitions: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("TopicPartitions expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionIdNode = _node.get("partitionId");
            if (_partitionIdNode == null) {
                throw new RuntimeException("TopicPartitions: unable to locate field 'partitionId', which is mandatory in version " + _version);
            } else {
                if (!_partitionIdNode.isArray()) {
                    throw new RuntimeException("TopicPartitions expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionIdNode.size());
                _object.partitionId = _collection;
                for (JsonNode _element : _partitionIdNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "TopicPartitions element"));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicPartitions _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionIdArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitionId) {
                _partitionIdArray.add(new IntNode(_element));
            }
            _node.set("partitionId", _partitionIdArray);
            return _node;
        }
        public static JsonNode write(TopicPartitions _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
