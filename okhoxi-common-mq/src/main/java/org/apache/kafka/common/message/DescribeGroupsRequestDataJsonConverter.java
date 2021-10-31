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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;

import static org.apache.kafka.common.message.DescribeGroupsRequestData.*;

public class DescribeGroupsRequestDataJsonConverter {
    public static DescribeGroupsRequestData read(JsonNode _node, short _version) {
        DescribeGroupsRequestData _object = new DescribeGroupsRequestData();
        JsonNode _groupsNode = _node.get("groups");
        if (_groupsNode == null) {
            throw new RuntimeException("DescribeGroupsRequestData: unable to locate field 'groups', which is mandatory in version " + _version);
        } else {
            if (!_groupsNode.isArray()) {
                throw new RuntimeException("DescribeGroupsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<String> _collection = new ArrayList<String>(_groupsNode.size());
            _object.groups = _collection;
            for (JsonNode _element : _groupsNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("DescribeGroupsRequestData element expected a string type, but got " + _node.getNodeType());
                }
                _collection.add(_element.asText());
            }
        }
        JsonNode _includeAuthorizedOperationsNode = _node.get("includeAuthorizedOperations");
        if (_includeAuthorizedOperationsNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("DescribeGroupsRequestData: unable to locate field 'includeAuthorizedOperations', which is mandatory in version " + _version);
            } else {
                _object.includeAuthorizedOperations = false;
            }
        } else {
            if (!_includeAuthorizedOperationsNode.isBoolean()) {
                throw new RuntimeException("DescribeGroupsRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.includeAuthorizedOperations = _includeAuthorizedOperationsNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(DescribeGroupsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _groupsArray = new ArrayNode(JsonNodeFactory.instance);
        for (String _element : _object.groups) {
            _groupsArray.add(new TextNode(_element));
        }
        _node.set("groups", _groupsArray);
        if (_version >= 3) {
            _node.set("includeAuthorizedOperations", BooleanNode.valueOf(_object.includeAuthorizedOperations));
        } else {
            if (_object.includeAuthorizedOperations) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeAuthorizedOperations at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(DescribeGroupsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
