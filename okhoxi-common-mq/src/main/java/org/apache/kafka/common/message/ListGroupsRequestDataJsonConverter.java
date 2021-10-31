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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;

import static org.apache.kafka.common.message.ListGroupsRequestData.*;

public class ListGroupsRequestDataJsonConverter {
    public static ListGroupsRequestData read(JsonNode _node, short _version) {
        ListGroupsRequestData _object = new ListGroupsRequestData();
        JsonNode _statesFilterNode = _node.get("statesFilter");
        if (_statesFilterNode == null) {
            if (_version >= 4) {
                throw new RuntimeException("ListGroupsRequestData: unable to locate field 'statesFilter', which is mandatory in version " + _version);
            } else {
                _object.statesFilter = new ArrayList<String>(0);
            }
        } else {
            if (!_statesFilterNode.isArray()) {
                throw new RuntimeException("ListGroupsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<String> _collection = new ArrayList<String>(_statesFilterNode.size());
            _object.statesFilter = _collection;
            for (JsonNode _element : _statesFilterNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("ListGroupsRequestData element expected a string type, but got " + _node.getNodeType());
                }
                _collection.add(_element.asText());
            }
        }
        return _object;
    }
    public static JsonNode write(ListGroupsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 4) {
            ArrayNode _statesFilterArray = new ArrayNode(JsonNodeFactory.instance);
            for (String _element : _object.statesFilter) {
                _statesFilterArray.add(new TextNode(_element));
            }
            _node.set("statesFilter", _statesFilterArray);
        } else {
            if (!_object.statesFilter.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default statesFilter at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(ListGroupsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
