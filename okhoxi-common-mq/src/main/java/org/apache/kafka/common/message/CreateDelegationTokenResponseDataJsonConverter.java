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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreateDelegationTokenResponseData.*;

public class CreateDelegationTokenResponseDataJsonConverter {
    public static CreateDelegationTokenResponseData read(JsonNode _node, short _version) {
        CreateDelegationTokenResponseData _object = new CreateDelegationTokenResponseData();
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "CreateDelegationTokenResponseData");
        }
        JsonNode _principalTypeNode = _node.get("principalType");
        if (_principalTypeNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'principalType', which is mandatory in version " + _version);
        } else {
            if (!_principalTypeNode.isTextual()) {
                throw new RuntimeException("CreateDelegationTokenResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.principalType = _principalTypeNode.asText();
        }
        JsonNode _principalNameNode = _node.get("principalName");
        if (_principalNameNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'principalName', which is mandatory in version " + _version);
        } else {
            if (!_principalNameNode.isTextual()) {
                throw new RuntimeException("CreateDelegationTokenResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.principalName = _principalNameNode.asText();
        }
        JsonNode _issueTimestampMsNode = _node.get("issueTimestampMs");
        if (_issueTimestampMsNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'issueTimestampMs', which is mandatory in version " + _version);
        } else {
            _object.issueTimestampMs = MessageUtil.jsonNodeToLong(_issueTimestampMsNode, "CreateDelegationTokenResponseData");
        }
        JsonNode _expiryTimestampMsNode = _node.get("expiryTimestampMs");
        if (_expiryTimestampMsNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'expiryTimestampMs', which is mandatory in version " + _version);
        } else {
            _object.expiryTimestampMs = MessageUtil.jsonNodeToLong(_expiryTimestampMsNode, "CreateDelegationTokenResponseData");
        }
        JsonNode _maxTimestampMsNode = _node.get("maxTimestampMs");
        if (_maxTimestampMsNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'maxTimestampMs', which is mandatory in version " + _version);
        } else {
            _object.maxTimestampMs = MessageUtil.jsonNodeToLong(_maxTimestampMsNode, "CreateDelegationTokenResponseData");
        }
        JsonNode _tokenIdNode = _node.get("tokenId");
        if (_tokenIdNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'tokenId', which is mandatory in version " + _version);
        } else {
            if (!_tokenIdNode.isTextual()) {
                throw new RuntimeException("CreateDelegationTokenResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.tokenId = _tokenIdNode.asText();
        }
        JsonNode _hmacNode = _node.get("hmac");
        if (_hmacNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'hmac', which is mandatory in version " + _version);
        } else {
            _object.hmac = MessageUtil.jsonNodeToBinary(_hmacNode, "CreateDelegationTokenResponseData");
        }
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("CreateDelegationTokenResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "CreateDelegationTokenResponseData");
        }
        return _object;
    }
    public static JsonNode write(CreateDelegationTokenResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("errorCode", new ShortNode(_object.errorCode));
        _node.set("principalType", new TextNode(_object.principalType));
        _node.set("principalName", new TextNode(_object.principalName));
        _node.set("issueTimestampMs", new LongNode(_object.issueTimestampMs));
        _node.set("expiryTimestampMs", new LongNode(_object.expiryTimestampMs));
        _node.set("maxTimestampMs", new LongNode(_object.maxTimestampMs));
        _node.set("tokenId", new TextNode(_object.tokenId));
        _node.set("hmac", new BinaryNode(Arrays.copyOf(_object.hmac, _object.hmac.length)));
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        return _node;
    }
    public static JsonNode write(CreateDelegationTokenResponseData _object, short _version) {
        return write(_object, _version, true);
    }
}
