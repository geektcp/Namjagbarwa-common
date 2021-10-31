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

import static org.apache.kafka.common.message.DescribeUserScramCredentialsResponseData.*;

public class DescribeUserScramCredentialsResponseDataJsonConverter {
    public static DescribeUserScramCredentialsResponseData read(JsonNode _node, short _version) {
        DescribeUserScramCredentialsResponseData _object = new DescribeUserScramCredentialsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeUserScramCredentialsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeUserScramCredentialsResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("DescribeUserScramCredentialsResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeUserScramCredentialsResponseData");
        }
        JsonNode _errorMessageNode = _node.get("errorMessage");
        if (_errorMessageNode == null) {
            throw new RuntimeException("DescribeUserScramCredentialsResponseData: unable to locate field 'errorMessage', which is mandatory in version " + _version);
        } else {
            if (_errorMessageNode.isNull()) {
                _object.errorMessage = null;
            } else {
                if (!_errorMessageNode.isTextual()) {
                    throw new RuntimeException("DescribeUserScramCredentialsResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.errorMessage = _errorMessageNode.asText();
            }
        }
        JsonNode _resultsNode = _node.get("results");
        if (_resultsNode == null) {
            throw new RuntimeException("DescribeUserScramCredentialsResponseData: unable to locate field 'results', which is mandatory in version " + _version);
        } else {
            if (!_resultsNode.isArray()) {
                throw new RuntimeException("DescribeUserScramCredentialsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribeUserScramCredentialsResult> _collection = new ArrayList<DescribeUserScramCredentialsResult>(_resultsNode.size());
            _object.results = _collection;
            for (JsonNode _element : _resultsNode) {
                _collection.add(DescribeUserScramCredentialsResultJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeUserScramCredentialsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_object.errorMessage == null) {
            _node.set("errorMessage", NullNode.instance);
        } else {
            _node.set("errorMessage", new TextNode(_object.errorMessage));
        }
        ArrayNode _resultsArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeUserScramCredentialsResult _element : _object.results) {
            _resultsArray.add(DescribeUserScramCredentialsResultJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("results", _resultsArray);
        return _node;
    }
    public static JsonNode write(DescribeUserScramCredentialsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class CredentialInfoJsonConverter {
        public static CredentialInfo read(JsonNode _node, short _version) {
            CredentialInfo _object = new CredentialInfo();
            JsonNode _mechanismNode = _node.get("mechanism");
            if (_mechanismNode == null) {
                throw new RuntimeException("CredentialInfo: unable to locate field 'mechanism', which is mandatory in version " + _version);
            } else {
                _object.mechanism = MessageUtil.jsonNodeToByte(_mechanismNode, "CredentialInfo");
            }
            JsonNode _iterationsNode = _node.get("iterations");
            if (_iterationsNode == null) {
                throw new RuntimeException("CredentialInfo: unable to locate field 'iterations', which is mandatory in version " + _version);
            } else {
                _object.iterations = MessageUtil.jsonNodeToInt(_iterationsNode, "CredentialInfo");
            }
            return _object;
        }
        public static JsonNode write(CredentialInfo _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("mechanism", new ShortNode(_object.mechanism));
            _node.set("iterations", new IntNode(_object.iterations));
            return _node;
        }
        public static JsonNode write(CredentialInfo _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeUserScramCredentialsResultJsonConverter {
        public static DescribeUserScramCredentialsResult read(JsonNode _node, short _version) {
            DescribeUserScramCredentialsResult _object = new DescribeUserScramCredentialsResult();
            JsonNode _userNode = _node.get("user");
            if (_userNode == null) {
                throw new RuntimeException("DescribeUserScramCredentialsResult: unable to locate field 'user', which is mandatory in version " + _version);
            } else {
                if (!_userNode.isTextual()) {
                    throw new RuntimeException("DescribeUserScramCredentialsResult expected a string type, but got " + _node.getNodeType());
                }
                _object.user = _userNode.asText();
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("DescribeUserScramCredentialsResult: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeUserScramCredentialsResult");
            }
            JsonNode _errorMessageNode = _node.get("errorMessage");
            if (_errorMessageNode == null) {
                throw new RuntimeException("DescribeUserScramCredentialsResult: unable to locate field 'errorMessage', which is mandatory in version " + _version);
            } else {
                if (_errorMessageNode.isNull()) {
                    _object.errorMessage = null;
                } else {
                    if (!_errorMessageNode.isTextual()) {
                        throw new RuntimeException("DescribeUserScramCredentialsResult expected a string type, but got " + _node.getNodeType());
                    }
                    _object.errorMessage = _errorMessageNode.asText();
                }
            }
            JsonNode _credentialInfosNode = _node.get("credentialInfos");
            if (_credentialInfosNode == null) {
                throw new RuntimeException("DescribeUserScramCredentialsResult: unable to locate field 'credentialInfos', which is mandatory in version " + _version);
            } else {
                if (!_credentialInfosNode.isArray()) {
                    throw new RuntimeException("DescribeUserScramCredentialsResult expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<CredentialInfo> _collection = new ArrayList<CredentialInfo>(_credentialInfosNode.size());
                _object.credentialInfos = _collection;
                for (JsonNode _element : _credentialInfosNode) {
                    _collection.add(CredentialInfoJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeUserScramCredentialsResult _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("user", new TextNode(_object.user));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            if (_object.errorMessage == null) {
                _node.set("errorMessage", NullNode.instance);
            } else {
                _node.set("errorMessage", new TextNode(_object.errorMessage));
            }
            ArrayNode _credentialInfosArray = new ArrayNode(JsonNodeFactory.instance);
            for (CredentialInfo _element : _object.credentialInfos) {
                _credentialInfosArray.add(CredentialInfoJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("credentialInfos", _credentialInfosArray);
            return _node;
        }
        public static JsonNode write(DescribeUserScramCredentialsResult _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
