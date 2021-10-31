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

import static org.apache.kafka.common.message.AlterReplicaLogDirsRequestData.*;

public class AlterReplicaLogDirsRequestDataJsonConverter {
    public static AlterReplicaLogDirsRequestData read(JsonNode _node, short _version) {
        AlterReplicaLogDirsRequestData _object = new AlterReplicaLogDirsRequestData();
        JsonNode _dirsNode = _node.get("dirs");
        if (_dirsNode == null) {
            throw new RuntimeException("AlterReplicaLogDirsRequestData: unable to locate field 'dirs', which is mandatory in version " + _version);
        } else {
            if (!_dirsNode.isArray()) {
                throw new RuntimeException("AlterReplicaLogDirsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            AlterReplicaLogDirCollection _collection = new AlterReplicaLogDirCollection(_dirsNode.size());
            _object.dirs = _collection;
            for (JsonNode _element : _dirsNode) {
                _collection.add(AlterReplicaLogDirJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterReplicaLogDirsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _dirsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AlterReplicaLogDir _element : _object.dirs) {
            _dirsArray.add(AlterReplicaLogDirJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("dirs", _dirsArray);
        return _node;
    }
    public static JsonNode write(AlterReplicaLogDirsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AlterReplicaLogDirJsonConverter {
        public static AlterReplicaLogDir read(JsonNode _node, short _version) {
            AlterReplicaLogDir _object = new AlterReplicaLogDir();
            JsonNode _pathNode = _node.get("path");
            if (_pathNode == null) {
                throw new RuntimeException("AlterReplicaLogDir: unable to locate field 'path', which is mandatory in version " + _version);
            } else {
                if (!_pathNode.isTextual()) {
                    throw new RuntimeException("AlterReplicaLogDir expected a string type, but got " + _node.getNodeType());
                }
                _object.path = _pathNode.asText();
            }
            JsonNode _topicsNode = _node.get("topics");
            if (_topicsNode == null) {
                throw new RuntimeException("AlterReplicaLogDir: unable to locate field 'topics', which is mandatory in version " + _version);
            } else {
                if (!_topicsNode.isArray()) {
                    throw new RuntimeException("AlterReplicaLogDir expected a JSON array, but got " + _node.getNodeType());
                }
                AlterReplicaLogDirTopicCollection _collection = new AlterReplicaLogDirTopicCollection(_topicsNode.size());
                _object.topics = _collection;
                for (JsonNode _element : _topicsNode) {
                    _collection.add(AlterReplicaLogDirTopicJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(AlterReplicaLogDir _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("path", new TextNode(_object.path));
            ArrayNode _topicsArray = new ArrayNode(JsonNodeFactory.instance);
            for (AlterReplicaLogDirTopic _element : _object.topics) {
                _topicsArray.add(AlterReplicaLogDirTopicJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("topics", _topicsArray);
            return _node;
        }
        public static JsonNode write(AlterReplicaLogDir _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class AlterReplicaLogDirTopicJsonConverter {
        public static AlterReplicaLogDirTopic read(JsonNode _node, short _version) {
            AlterReplicaLogDirTopic _object = new AlterReplicaLogDirTopic();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("AlterReplicaLogDirTopic: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("AlterReplicaLogDirTopic expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _partitionsNode = _node.get("partitions");
            if (_partitionsNode == null) {
                throw new RuntimeException("AlterReplicaLogDirTopic: unable to locate field 'partitions', which is mandatory in version " + _version);
            } else {
                if (!_partitionsNode.isArray()) {
                    throw new RuntimeException("AlterReplicaLogDirTopic expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<Integer> _collection = new ArrayList<Integer>(_partitionsNode.size());
                _object.partitions = _collection;
                for (JsonNode _element : _partitionsNode) {
                    _collection.add(MessageUtil.jsonNodeToInt(_element, "AlterReplicaLogDirTopic element"));
                }
            }
            return _object;
        }
        public static JsonNode write(AlterReplicaLogDirTopic _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            ArrayNode _partitionsArray = new ArrayNode(JsonNodeFactory.instance);
            for (Integer _element : _object.partitions) {
                _partitionsArray.add(new IntNode(_element));
            }
            _node.set("partitions", _partitionsArray);
            return _node;
        }
        public static JsonNode write(AlterReplicaLogDirTopic _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
