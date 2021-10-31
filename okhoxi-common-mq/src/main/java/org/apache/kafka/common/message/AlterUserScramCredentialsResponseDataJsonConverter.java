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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AlterUserScramCredentialsResponseData.*;

public class AlterUserScramCredentialsResponseDataJsonConverter {
    public static AlterUserScramCredentialsResponseData read(JsonNode _node, short _version) {
        AlterUserScramCredentialsResponseData _object = new AlterUserScramCredentialsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("AlterUserScramCredentialsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "AlterUserScramCredentialsResponseData");
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("AlterUserScramCredentialsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("AlterUserScramCredentialsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<AlterUserScramCredentialsResult> _collection = new ArrayList<AlterUserScramCredentialsResult>(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(AlterUserScramCredentialsResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterUserScramCredentialsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AlterUserScramCredentialsResult _element : _object.results) {
            _resultsArray.add(AlterUserScramCredentialsResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(AlterUserScramCredentialsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AlterUserScramCredentialsResultJsonConverter {
        public static AlterUserScramCredentialsResult read(JsonNode _node, short _version) {
            AlterUserScramCredentialsResult _object = new AlterUserScramCredentialsResult();
            JsonNode _userNode = _node.get("user");
            if (_userNode == null) {
                throw new RuntimeException("AlterUserScramCredentialsResult: unable to locate field 'user', which is mandatory in version " + _version);
            } else {
                if (!_userNode.isTextual()) {
                    throw new RuntimeException("AlterUserScramCredentialsResult expected a string type, but got " + _node.getNodeType());
                }
                _object.user = _userNode.asText();
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("AlterUserScramCredentialsResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "AlterUserScramCredentialsResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                throw new RuntimeException("AlterUserScramCredentialsResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("AlterUserScramCredentialsResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(AlterUserScramCredentialsResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("user", new TextNode(_object.user));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
            return _node;
        }
        public static JsonNode write(AlterUserScramCredentialsResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
