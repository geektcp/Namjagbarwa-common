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

import static org.apache.kafka.common.message.DeleteGroupsResponseData.*;

public class DeleteGroupsResponseDataJsonConverter {
    public static DeleteGroupsResponseData read(JsonNode _node, short _version) {
        DeleteGroupsResponseData _object = new DeleteGroupsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DeleteGroupsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DeleteGroupsResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("DeleteGroupsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("DeleteGroupsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            DeletableGroupResultCollection _collection = new DeletableGroupResultCollection(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(DeletableGroupResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DeleteGroupsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DeletableGroupResult _element : _object.results) {
            _resultsArray.add(DeletableGroupResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(DeleteGroupsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DeletableGroupResultJsonConverter {
        public static DeletableGroupResult read(JsonNode _node, short _version) {
            DeletableGroupResult _object = new DeletableGroupResult();
            JsonNode _groupIdNode = _node.get("groupId");
            if (_groupIdNode == null) {
                throw new RuntimeException("DeletableGroupResult: unable to locate field 'groupId', which is mandatory in version " + _version);
            } else {
                if (!_groupIdNode.isTextual()) {
                    throw new RuntimeException("DeletableGroupResult expected a string type, but got " + _node.getNodeType());
                }
                _object.groupId = _groupIdNode.asText();
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DeletableGroupResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DeletableGroupResult");
            }
            return _object;
        }
        public static JsonNode write(DeletableGroupResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("groupId", new TextNode(_object.groupId));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            return _node;
        }
        public static JsonNode write(DeletableGroupResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
