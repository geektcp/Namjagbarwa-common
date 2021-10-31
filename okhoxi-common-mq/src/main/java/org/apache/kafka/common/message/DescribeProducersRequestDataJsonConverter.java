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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeProducersRequestData.*;

public class DescribeProducersRequestDataJsonConverter {
    public static DescribeProducersRequestData read(JsonNode _node, short _version) {
        DescribeProducersRequestData _object = new DescribeProducersRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("DescribeProducersRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (!_topicsNode.isArray()) {
                throw new RuntimeException("DescribeProducersRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<TopicRequest> _collection = new ArrayList<TopicRequest>(_topicsNode.size());
            _object.topics = _collection;
            for (JsonNode _element : _topicsNode) {
                _collection.add(TopicRequestJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeProducersRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
        for (TopicRequest _element : _object.topics) {
            _topicsArray.add(TopicRequestJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("topics", _topicsArray);
        return _node;
    }
    public static JsonNode write(DescribeProducersRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class TopicRequestJsonConverter {
        public static TopicRequest read(JsonNode _node, short _version) {
            TopicRequest _object = new TopicRequest();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("TopicRequest: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("TopicRequest expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionIndexesNode = _node.get("partitionIndexes");
            if (_partitionIndexesNode == null) {
                throw new RuntimeException("TopicRequest: unable to locate field 'partitionIndexes', which is mandatory in version " + _version);
            } else {
                if (!_partitionIndexesNode.isArray()) {
                    throw new RuntimeException("TopicRequest expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionIndexesNode.size());
                _object.partitionIndexes = _collection;
                for (JsonNode _element : _partitionIndexesNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "TopicRequest element"));
                }
            }
            return _object;
        }
        public static JsonNode write(TopicRequest _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionIndexesArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitionIndexes) {
                _partitionIndexesArray.add(new IntNode(_element));
            }
            _node.set("partitionIndexes", _partitionIndexesArray);
            return _node;
        }
        public static JsonNode write(TopicRequest _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
