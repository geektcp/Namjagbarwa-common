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

import static org.apache.kafka.common.message.DeleteGroupsRequestData.*;

public class DeleteGroupsRequestDataJsonConverter {
    public static DeleteGroupsRequestData read(JsonNode _node, short _version) {
        DeleteGroupsRequestData _object = new DeleteGroupsRequestData();
        JsonNode _groupsNamesNode = _node.get("groupsNames");
        if (_groupsNamesNode == null) {
            throw new RuntimeException("DeleteGroupsRequestData: unable to locate field 'groupsNames', which is mandatory in version " + _version);
        } else {
            if (!_groupsNamesNode.isArray()) {
                throw new RuntimeException("DeleteGroupsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<String> _collection = new ArrayList<String>(_groupsNamesNode.size());
            _object.groupsNames = _collection;
            for (JsonNode _element : _groupsNamesNode) {
                if (!_element.isTextual()) {
                    throw new RuntimeException("DeleteGroupsRequestData element expected a string type, but got " + _node.getNodeType());
                }
                _collection.add(_element.asText());
            }
        }
        return _object;
    }
    public static JsonNode write(DeleteGroupsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _groupsNamesArray = new ArrayNode(JsonNodeFactory.instance);
        for (String _element : _object.groupsNames) {
            _groupsNamesArray.add(new TextNode(_element));
        }
        _node.set("groupsNames", _groupsNamesArray);
        return _node;
    }
    public static JsonNode write(DeleteGroupsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
