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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ConsumerProtocolSubscription.*;

public class ConsumerProtocolSubscriptionJsonConverter {
    public static ConsumerProtocolSubscription read(JsonNode _node, short _version) {
        ConsumerProtocolSubscription _object = new ConsumerProtocolSubscription();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("ConsumerProtocolSubscription: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("ConsumerProtocolSubscription expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<String> _collection = new ArrayList<String>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("ConsumerProtocolSubscription element expected a string type, but got " + _node.getNodeType());
                }
                _collection.add(_element.asText());
            }
        }
        JsonNode _userDataNode = _node.get("userData");
        if (_userDataNode == null) {
            throw new RuntimeException("ConsumerProtocolSubscription: unable to locate field 'userData', which is mandatory in version " + _version);
        } else {
            if (_userDataNode.isNull()) {
                _object.userData = null;
            } else {
                _object.userData = ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_userDataNode, "ConsumerProtocolSubscription"));
            }
        }
        JsonNode _ownedPartitionsNode = _node.get("ownedPartitions");
        if (_ownedPartitionsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("ConsumerProtocolSubscription: unable to locate field 'ownedPartitions', which is mandatory in version " + _version);
            } else {
                _object.ownedPartitions = new ArrayList<TopicPartition>(0);
            }
        } else {
            if (!_ownedPartitionsNode.isArray()) {
                throw new RuntimeException("ConsumerProtocolSubscription expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicPartition> _collection = new ArrayList<TopicPartition>(_ownedPartitionsNode.size());
            _object.ownedPartitions = _collection;
            for (JsonNode _element : _ownedPartitionsNode) {
                _collection.add(TopicPartitionJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ConsumerProtocolSubscription _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (String _element : _object.topics) {
            _topicsArray.add(new TextNode(_element));
        }
        _node.set("topics", _topicsArray);
        if (_object.userData == null) {
            _node.set("userData", NullNode.instance);
        } else {
            _node.set("userData", new BinaryNode(MessageUtil.byteBufferToArray(_object.userData)));
        }
        if (_version >= 1) {
            ArrayNode _ownedPartitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (TopicPartition _element : _object.ownedPartitions) {
                _ownedPartitionsArray.add(TopicPartitionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("ownedPartitions", _ownedPartitionsArray);
        }
        return _node;
    }
    public static JsonNode write(ConsumerProtocolSubscription _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class TopicPartitionJsonConverter {
        public static TopicPartition read(JsonNode _node, short _version) {
            TopicPartition _object = new TopicPartition();
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of TopicPartition");
            }
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("TopicPartition: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("TopicPartition expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("TopicPartition: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("TopicPartition expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "TopicPartition element"));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicPartition _object, short _version, boolean _serializeRecords) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of TopicPartition");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitions) {
                _partitionsArray.add(new IntNode(_element));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(TopicPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
