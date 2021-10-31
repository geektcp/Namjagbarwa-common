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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;

import static org.apache.kafka.common.message.DescribeUserScramCredentialsRequestData.*;

public class DescribeUserScramCredentialsRequestDataJsonConverter {
    public static DescribeUserScramCredentialsRequestData read(JsonNode _node, short _version) {
        DescribeUserScramCredentialsRequestData _object = new DescribeUserScramCredentialsRequestData();
        JsonNode _usersNode = _node.get("users");
        if (_usersNode == null) {
            throw new RuntimeException("DescribeUserScramCredentialsRequestData: unable to locate field 'users', which is mandatory in version " + _version);
        } else {
            if (_usersNode.isNull()) {
                _object.users = null;
            } else {
                if (!_usersNode.isArray()) {
                    throw new RuntimeException("DescribeUserScramCredentialsRequestData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<UserName> _collection = new ArrayList<UserName>(_usersNode.size());
                _object.users = _collection;
                for (JsonNode _element : _usersNode) {
                    _collection.add(UserNameJsonConverter.read(_element, _version));
                }
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeUserScramCredentialsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.users == null) {
            _node.set("users", NullNode.instance);
        } else {
            ArrayNode _usersArray = new ArrayNode(JsonNodeFactory.instance);
            for (UserName _element : _object.users) {
                _usersArray.add(UserNameJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("users", _usersArray);
        }
        return _node;
    }
    public static JsonNode write(DescribeUserScramCredentialsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class UserNameJsonConverter {
        public static UserName read(JsonNode _node, short _version) {
            UserName _object = new UserName();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("UserName: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("UserName expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            return _object;
        }
        public static JsonNode write(UserName _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            return _node;
        }
        public static JsonNode write(UserName _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
