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
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeLogDirsRequestData.*;

public class DescribeLogDirsRequestDataJsonConverter {
    public static DescribeLogDirsRequestData read(JsonNode _node, short _version) {
        DescribeLogDirsRequestData _object = new DescribeLogDirsRequestData();
        JsonNode _topicsNode = _node.get("topics");
        if (_topicsNode == null) {
            throw new RuntimeException("DescribeLogDirsRequestData: unable to locate field 'topics', which is mandatory in version " + _version);
        } else {
            if (_topicsNode.isNull()) {
                _object.topics = null;
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("DescribeLogDirsRequestData expected a JSON array, but got " + _node.getNodeType());
                }
                DescribableLogDirTopicCollection _collection = new DescribableLogDirTopicCollection(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(DescribableLogDirTopicJsonConverter.read(_element, _version));
                }
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeLogDirsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.topics == null) {
            _node.set("topics", NullNode.instance);
        } else {
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribableLogDirTopic _element : _object.topics) {
                _topicsArray.add(DescribableLogDirTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
        }
        return _node;
    }
    public static JsonNode write(DescribeLogDirsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribableLogDirTopicJsonConverter {
        public static DescribableLogDirTopic read(JsonNode _node, short _version) {
            DescribableLogDirTopic _object = new DescribableLogDirTopic();
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("DescribableLogDirTopic: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("DescribableLogDirTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionIndexNode = _node.get("partitionIndex");
            if (_partitionIndexNode == null) {
                throw new RuntimeException("DescribableLogDirTopic: unable to locate field 'partitionIndex', which is mandatory in version " + _version);
            } else {
                if (!_partitionIndexNode.isArray()) {
                    throw new RuntimeException("DescribableLogDirTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionIndexNode.size());
                _object.partitionIndex = _collection;
                for (JsonNode _element : _partitionIndexNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "DescribableLogDirTopic element"));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribableLogDirTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionIndexArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitionIndex) {
                _partitionIndexArray.add(new IntNode(_element));
            }
            _node.set("partitionIndex", _partitionIndexArray);
            return _node;
        }
        public static JsonNode write(DescribableLogDirTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
