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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeDelegationTokenResponseData.*;

public class DescribeDelegationTokenResponseDataJsonConverter {
    public static DescribeDelegationTokenResponseData read(JsonNode _node, short _version) {
        DescribeDelegationTokenResponseData _object = new DescribeDelegationTokenResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("DescribeDelegationTokenResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeDelegationTokenResponseData");
        }
        JsonNode _tokensNode = _node.get("tokens");
        if (_tokensNode == null) {
            throw new RuntimeException("DescribeDelegationTokenResponseData: unable to locate field 'tokens', which is mandatory in version " + _version);
        } else {
            if (!_tokensNode.isArray()) {
                throw new RuntimeException("DescribeDelegationTokenResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribedDelegationToken> _collection = new ArrayList<DescribedDelegationToken>(_tokensNode.size());
            _object.tokens = _collection;
            for (JsonNode _element : _tokensNode) {
                _collection.add(DescribedDelegationTokenJsonConverter.read(_element, _version));
            }
        }
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeDelegationTokenResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeDelegationTokenResponseData");
        }
        return _object;
    }
    public static JsonNode write(DescribeDelegationTokenResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        ArrayNode _tokensArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribedDelegationToken _element : _object.tokens) {
            _tokensArray.add(DescribedDelegationTokenJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("tokens", _tokensArray);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        return _node;
    }
    public static JsonNode write(DescribeDelegationTokenResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribedDelegationTokenJsonConverter {
        public static DescribedDelegationToken read(JsonNode _node, short _version) {
            DescribedDelegationToken _object = new DescribedDelegationToken();
            JsonNode _principalTypeNode = _node.get("principalType");
            if (_principalTypeNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'principalType', which is mandatory in version " + _version);
            } else {
                if (!_principalTypeNode.isTextual()) {
                    throw new RuntimeException("DescribedDelegationToken expected a string type, but got " + _node.getNodeType());
                }
                _object.principalType = _principalTypeNode.asText();
            }
            JsonNode _principalNameNode = _node.get("principalName");
            if (_principalNameNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'principalName', which is mandatory in version " + _version);
            } else {
                if (!_principalNameNode.isTextual()) {
                    throw new RuntimeException("DescribedDelegationToken expected a string type, but got " + _node.getNodeType());
                }
                _object.principalName = _principalNameNode.asText();
            }
            JsonNode _issueTimestampNode = _node.get("issueTimestamp");
            if (_issueTimestampNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'issueTimestamp', which is mandatory in version " + _version);
            } else {
                _object.issueTimestamp = MessageUtil.jsonNodeToLong(_issueTimestampNode, "DescribedDelegationToken");
            }
            JsonNode _expiryTimestampNode = _node.get("expiryTimestamp");
            if (_expiryTimestampNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'expiryTimestamp', which is mandatory in version " + _version);
            } else {
                _object.expiryTimestamp = MessageUtil.jsonNodeToLong(_expiryTimestampNode, "DescribedDelegationToken");
            }
            JsonNode _maxTimestampNode = _node.get("maxTimestamp");
            if (_maxTimestampNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'maxTimestamp', which is mandatory in version " + _version);
            } else {
                _object.maxTimestamp = MessageUtil.jsonNodeToLong(_maxTimestampNode, "DescribedDelegationToken");
            }
            JsonNode _tokenIdNode = _node.get("tokenId");
            if (_tokenIdNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'tokenId', which is mandatory in version " + _version);
            } else {
                if (!_tokenIdNode.isTextual()) {
                    throw new RuntimeException("DescribedDelegationToken expected a string type, but got " + _node.getNodeType());
                }
                _object.tokenId = _tokenIdNode.asText();
            }
            JsonNode _hmacNode = _node.get("hmac");
            if (_hmacNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'hmac', which is mandatory in version " + _version);
            } else {
                _object.hmac = MessageUtil.jsonNodeToBinary(_hmacNode, "DescribedDelegationToken");
            }
            JsonNode _renewersNode = _node.get("renewers");
            if (_renewersNode == null) {
                throw new RuntimeException("DescribedDelegationToken: unable to locate field 'renewers', which is mandatory in version " + _version);
            } else {
                if (!_renewersNode.isArray()) {
                    throw new RuntimeException("DescribedDelegationToken expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribedDelegationTokenRenewer> _collection = new ArrayList<DescribedDelegationTokenRenewer>(_renewersNode.size());
                _object.renewers = _collection;
                for (JsonNode _element : _renewersNode) {
                    _collection.add(DescribedDelegationTokenRenewerJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribedDelegationToken _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("principalType", new TextNode(_object.principalType));
            _node.set("principalName", new TextNode(_object.principalName));
            _node.set("issueTimestamp", new LongNode(_object.issueTimestamp));
            _node.set("expiryTimestamp", new LongNode(_object.expiryTimestamp));
            _node.set("maxTimestamp", new LongNode(_object.maxTimestamp));
            _node.set("tokenId", new TextNode(_object.tokenId));
            _node.set("hmac", new BinaryNode(Arrays.copyOf(_object.hmac, _object.hmac.length)));
            ArrayNode _renewersArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribedDelegationTokenRenewer _element : _object.renewers) {
                _renewersArray.add(DescribedDelegationTokenRenewerJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("renewers", _renewersArray);
            return _node;
        }
        public static JsonNode write(DescribedDelegationToken _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribedDelegationTokenRenewerJsonConverter {
        public static DescribedDelegationTokenRenewer read(JsonNode _node, short _version) {
            DescribedDelegationTokenRenewer _object = new DescribedDelegationTokenRenewer();
            JsonNode _principalTypeNode = _node.get("principalType");
            if (_principalTypeNode == null) {
                throw new RuntimeException("DescribedDelegationTokenRenewer: unable to locate field 'principalType', which is mandatory in version " + _version);
            } else {
                if (!_principalTypeNode.isTextual()) {
                    throw new RuntimeException("DescribedDelegationTokenRenewer expected a string type, but got " + _node.getNodeType());
                }
                _object.principalType = _principalTypeNode.asText();
            }
            JsonNode _principalNameNode = _node.get("principalName");
            if (_principalNameNode == null) {
                throw new RuntimeException("DescribedDelegationTokenRenewer: unable to locate field 'principalName', which is mandatory in version " + _version);
            } else {
                if (!_principalNameNode.isTextual()) {
                    throw new RuntimeException("DescribedDelegationTokenRenewer expected a string type, but got " + _node.getNodeType());
                }
                _object.principalName = _principalNameNode.asText();
            }
            return _object;
        }
        public static JsonNode write(DescribedDelegationTokenRenewer _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("principalType", new TextNode(_object.principalType));
            _node.set("principalName", new TextNode(_object.principalName));
            return _node;
        }
        public static JsonNode write(DescribedDelegationTokenRenewer _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
