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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.ControlledShutdownResponseData.*;

public class ControlledShutdownResponseDataJsonConverter {
    public static ControlledShutdownResponseData read(JsonNode _node, short _version) {
        ControlledShutdownResponseData _object = new ControlledShutdownResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("ControlledShutdownResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "ControlledShutdownResponseData");
        }
        JsonNode _remainingPartitionsNode = _node.get("remainingPartitions");
        if (_remainingPartitionsNode == null) {
            throw new RuntimeException("ControlledShutdownResponseData: unable to locate field 'remainingPartitions', which is mandatory in version " + _version);
        } else {
            if (!_remainingPartitionsNode.isArray()) {
                throw new RuntimeException("ControlledShutdownResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            RemainingPartitionCollection _collection = new RemainingPartitionCollection(_remainingPartitionsNode.size());
            _object.remainingPartitions = _collection;
            for (JsonNode _element : _remainingPartitionsNode) {
                _collection.add(RemainingPartitionJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(ControlledShutdownResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _remainingPartitionsArray = new ArrayNode(JsonNodeFactory.instance);
        for (RemainingPartition _element : _object.remainingPartitions) {
            _remainingPartitionsArray.add(RemainingPartitionJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("remainingPartitions", _remainingPartitionsArray);
        return _node;
    }
    public static JsonNode write(ControlledShutdownResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class RemainingPartitionJsonConverter {
        public static RemainingPartition read(JsonNode _node, short _version) {
            RemainingPartition _object = new RemainingPartition();
            JsonNode _topicNameNode = _node.get("topicName");
            if (_topicNameNode == null) {
                throw new RuntimeException("RemainingPartition: unable to locate field 'topicName', which is mandatory in version " + _version);
            } else {
                if (!_topicNameNode.isTextual()) {
                    throw new RuntimeException("RemainingPartition expected a string type, but got " + _node.getNodeType());
                }
                _object.topicName = _topicNameNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("RemainingPartition: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                _object.partitionIndex = MessageUtil.jsonNodeToInt(_partitionIndexNode, "RemainingPartition");
            }
            return _object;
        }
        public static JsonNode write(RemainingPartition _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topicName", new TextNode(_object.topicName));
            _node.set("partitionIndex", new IntNode(_object.partitionIndex));
            return _node;
        }
        public static JsonNode write(RemainingPartition _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
