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
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AddPartitionsToTxnRequestData.*;

public class AddPartitionsToTxnRequestDataJsonConverter {
    public static AddPartitionsToTxnRequestData read(JsonNode _node, short _version) {
        AddPartitionsToTxnRequestData _object = new AddPartitionsToTxnRequestData();
        JsonNode _transactionalIdNode = _node.get("transactionalId");
        if (_transactionalIdNode == null) {
            throw new RuntimeException("AddPartitionsToTxnRequestData: unable to locate field 'transactionalId', which is mandatory in version " + _version);
        } else {
            if (!_transactionalIdNode.isTextual()) {
                throw new RuntimeException("AddPartitionsToTxnRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.transactionalId = _transactionalIdNode.asText();
        }
        JsonNode _producerIdNode = _node.get("producerId");
        if (_producerIdNode == null) {
            throw new RuntimeException("AddPartitionsToTxnRequestData: unable to locate field 'producerId', which is mandatory in version " + _version);
        } else {
            _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "AddPartitionsToTxnRequestData");
        }
        JsonNode _producerEpochNode = _node.get("producerEpoch");
        if (_producerEpochNode == null) {
            throw new RuntimeException("AddPartitionsToTxnRequestData: unable to locate field 'producerEpoch', which is mandatory in version " + _version);
        } else {
            _object.producerEpoch = MessageUtil.jsonNodeToShort(_producerEpochNode, "AddPartitionsToTxnRequestData");
        }
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("AddPartitionsToTxnRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("AddPartitionsToTxnRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            AddPartitionsToTxnTopicCollection _collection = new AddPartitionsToTxnTopicCollection(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(AddPartitionsToTxnTopicJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AddPartitionsToTxnRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("transactionalId", new TextNode(_object.transactionalId));
        _node.set("producerId", new LongNode(_object.producerId));
        _node.set("producerEpoch", new ShortNode(_object.producerEpoch));
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AddPartitionsToTxnTopic _element : _object.topics) {
            _topicsArray.add(AddPartitionsToTxnTopicJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(AddPartitionsToTxnRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AddPartitionsToTxnTopicJsonConverter {
        public static AddPartitionsToTxnTopic read(JsonNode _node, short _version) {
            AddPartitionsToTxnTopic _object = new AddPartitionsToTxnTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("AddPartitionsToTxnTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("AddPartitionsToTxnTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("AddPartitionsToTxnTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("AddPartitionsToTxnTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "AddPartitionsToTxnTopic element"));
                }
            }
            return _object;
        }
        public static JsonNode write(AddPartitionsToTxnTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitions) {
                _partitionsArray.add(new IntNode(_element));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(AddPartitionsToTxnTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
