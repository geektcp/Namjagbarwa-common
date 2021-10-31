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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.record.MemoryRecords;

import static org.apache.kafka.common.message.FetchResponseData.*;

public class FetchResponseDataJsonConverter {
    public static FetchResponseData read(JsonNode _node, short _version) {
        FetchResponseData _object = new FetchResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("FetchResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
            } else {
                _object.throttleTimeMs = 0;
            }
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "FetchResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("FetchResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = (short) 0;
            }
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "FetchResponseData");
        }
        JsonNode _sessionIdNode = _node.get("sessionId");
        if (_sessionIdNode == null) {
            if (_version >= 7) {
                throw new RuntimeException("FetchResponseData: unable to locate field 'sessionId', which is mandatory in version " + _version);
            } else {
                _object.sessionId = 0;
            }
        } else {
            _object.sessionId = MessageUtil.jsonNodeToInt(_sessionIdNode, "FetchResponseData");
        }
        JsonNode _responsesNode = _node.get("responses");
        if (_responsesNode == null) {
            throw new RuntimeException("FetchResponseData: unable to locate field 'responses', which is mandatory in version " + _version);
        } else {
            if (!_responsesNode.isArray()) {
                throw new RuntimeException("FetchResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<FetchableTopicResponse> _collection = new ArrayList<FetchableTopicResponse>(_responsesNode.size());
            _object.responses = _collection;
            for (JsonNode _element : _responsesNode) {
                _collection.add(FetchableTopicResponseJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(FetchResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 1) {
            _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        }
        if (_version >= 7) {
            _node.set("errorCode", new ShortNode(_object.errorCode));
        }
        if (_version >= 7) {
            _node.set("sessionId", new IntNode(_object.sessionId));
        } else {
            if (_object.sessionId != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default sessionId at version " + _version);
            }
        }
        ArrayNode _responsesArray = new ArrayNode(JsonNodeFactory.instance);
        for (FetchableTopicResponse _element : _object.responses) {
            _responsesArray.add(FetchableTopicResponseJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("responses", _responsesArray);
        return _node;
    }
    public static JsonNode write(FetchResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AbortedTransactionJsonConverter {
        public static AbortedTransaction read(JsonNode _node, short _version) {
            AbortedTransaction _object = new AbortedTransaction();
            if (_version < 4) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of AbortedTransaction");
            }
            JsonNode _producerIdNode = _node.get("producerId");
            if (_producerIdNode == null) {
                throw new RuntimeException("AbortedTransaction: unable to locate field 'producerId', which is mandatory in version " + _version);
            } else {
                _object.producerId = MessageUtil.jsonNodeToLong(_producerIdNode, "AbortedTransaction");
            }
            JsonNode _firstOffsetNode = _node.get("firstOffset");
            if (_firstOffsetNode == null) {
                throw new RuntimeException("AbortedTransaction: unable to locate field 'firstOffset', which is mandatory in version " + _version);
            } else {
                _object.firstOffset = MessageUtil.jsonNodeToLong(_firstOffsetNode, "AbortedTransaction");
            }
            return _object;
        }
        public static JsonNode write(AbortedTransaction _object, short _version, boolean _serializeRecords) {
            if (_version < 4) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of AbortedTransaction");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("producerId", new LongNode(_object.producerId));
            _node.set("firstOffset", new LongNode(_object.firstOffset));
            return _node;
        }
        public static JsonNode write(AbortedTransaction _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class EpochEndOffsetJsonConverter {
        public static EpochEndOffset read(JsonNode _node, short _version) {
            EpochEndOffset _object = new EpochEndOffset();
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of EpochEndOffset");
            }
            JsonNode _epochNode = _node.get("epoch");
            if (_epochNode == null) {
                throw new RuntimeException("EpochEndOffset: unable to locate field 'epoch', which is mandatory in version " + _version);
            } else {
                _object.epoch = MessageUtil.jsonNodeToInt(_epochNode, "EpochEndOffset");
            }
            JsonNode _endOffsetNode = _node.get("endOffset");
            if (_endOffsetNode == null) {
                throw new RuntimeException("EpochEndOffset: unable to locate field 'endOffset', which is mandatory in version " + _version);
            } else {
                _object.endOffset = MessageUtil.jsonNodeToLong(_endOffsetNode, "EpochEndOffset");
            }
            return _object;
        }
        public static JsonNode write(EpochEndOffset _object, short _version, boolean _serializeRecords) {
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of EpochEndOffset");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("epoch", new IntNode(_object.epoch));
            _node.set("endOffset", new LongNode(_object.endOffset));
            return _node;
        }
        public static JsonNode write(EpochEndOffset _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class FetchablePartitionResponseJsonConverter {
        public static FetchablePartitionResponse read(JsonNode _node, short _version) {
            FetchablePartitionResponse _object = new FetchablePartitionResponse();
            JsonNode _partitionNode = _node.get("partition");
            if (_partitionNode == null) {
                throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'partition', which is mandatory in version " + _version);
            } else {
                _object.partition = MessageUtil.jsonNodeToInt(_partitionNode, "FetchablePartitionResponse");
            }
            JsonNode _errorCodeNode = _node.get("errorCode");
            if (_errorCodeNode == null) {
                throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'errorCode', which is mandatory in version " + _version);
            } else {
                _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "FetchablePartitionResponse");
            }
            JsonNode _highWatermarkNode = _node.get("highWatermark");
            if (_highWatermarkNode == null) {
                throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'highWatermark', which is mandatory in version " + _version);
            } else {
                _object.highWatermark = MessageUtil.jsonNodeToLong(_highWatermarkNode, "FetchablePartitionResponse");
            }
            JsonNode _lastStableOffsetNode = _node.get("lastStableOffset");
            if (_lastStableOffsetNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'lastStableOffset', which is mandatory in version " + _version);
                } else {
                    _object.lastStableOffset = -1L;
                }
            } else {
                _object.lastStableOffset = MessageUtil.jsonNodeToLong(_lastStableOffsetNode, "FetchablePartitionResponse");
            }
            JsonNode _logStartOffsetNode = _node.get("logStartOffset");
            if (_logStartOffsetNode == null) {
                if (_version >= 5) {
                    throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'logStartOffset', which is mandatory in version " + _version);
                } else {
                    _object.logStartOffset = -1L;
                }
            } else {
                _object.logStartOffset = MessageUtil.jsonNodeToLong(_logStartOffsetNode, "FetchablePartitionResponse");
            }
            JsonNode _divergingEpochNode = _node.get("divergingEpoch");
            if (_divergingEpochNode == null) {
                _object.divergingEpoch = new EpochEndOffset();
            } else {
                _object.divergingEpoch = EpochEndOffsetJsonConverter.read(_divergingEpochNode, _version);
            }
            JsonNode _currentLeaderNode = _node.get("currentLeader");
            if (_currentLeaderNode == null) {
                _object.currentLeader = new LeaderIdAndEpoch();
            } else {
                _object.currentLeader = LeaderIdAndEpochJsonConverter.read(_currentLeaderNode, _version);
            }
            JsonNode _snapshotIdNode = _node.get("snapshotId");
            if (_snapshotIdNode == null) {
                _object.snapshotId = new SnapshotId();
            } else {
                _object.snapshotId = SnapshotIdJsonConverter.read(_snapshotIdNode, _version);
            }
            JsonNode _abortedTransactionsNode = _node.get("abortedTransactions");
            if (_abortedTransactionsNode == null) {
                if (_version >= 4) {
                    throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'abortedTransactions', which is mandatory in version " + _version);
                } else {
                    _object.abortedTransactions = new ArrayList<AbortedTransaction>(0);
                }
            } else {
                if (_abortedTransactionsNode.isNull()) {
                    _object.abortedTransactions = null;
                } else {
                    if (!_abortedTransactionsNode.isArray()) {
                        throw new RuntimeException("FetchablePartitionResponse expected a JSON array, but got " + _node.getNodeType());
                    }
                    ArrayList<AbortedTransaction> _collection = new ArrayList<AbortedTransaction>(_abortedTransactionsNode.size());
                    _object.abortedTransactions = _collection;
                    for (JsonNode _element : _abortedTransactionsNode) {
                        _collection.add(AbortedTransactionJsonConverter.read(_element, _version));
                    }
                }
            }
            JsonNode _preferredReadReplicaNode = _node.get("preferredReadReplica");
            if (_preferredReadReplicaNode == null) {
                if (_version >= 11) {
                    throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'preferredReadReplica', which is mandatory in version " + _version);
                } else {
                    _object.preferredReadReplica = -1;
                }
            } else {
                _object.preferredReadReplica = MessageUtil.jsonNodeToInt(_preferredReadReplicaNode, "FetchablePartitionResponse");
            }
            JsonNode _recordSetNode = _node.get("recordSet");
            if (_recordSetNode == null) {
                throw new RuntimeException("FetchablePartitionResponse: unable to locate field 'recordSet', which is mandatory in version " + _version);
            } else {
                if (_recordSetNode.isNull()) {
                    _object.recordSet = null;
                } else {
                    _object.recordSet = MemoryRecords.readableRecords(ByteBuffer.wrap(MessageUtil.jsonNodeToBinary(_recordSetNode, "FetchablePartitionResponse")));
                }
            }
            return _object;
        }
        public static JsonNode write(FetchablePartitionResponse _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("partition", new IntNode(_object.partition));
            _node.set("errorCode", new ShortNode(_object.errorCode));
            _node.set("highWatermark", new LongNode(_object.highWatermark));
            if (_version >= 4) {
                _node.set("lastStableOffset", new LongNode(_object.lastStableOffset));
            }
            if (_version >= 5) {
                _node.set("logStartOffset", new LongNode(_object.logStartOffset));
            }
            if (_version >= 12) {
                if (!_object.divergingEpoch.equals(new EpochEndOffset())) {
                    _node.set("divergingEpoch", EpochEndOffsetJsonConverter.write(_object.divergingEpoch, _version, _serializeRecords));
                }
            } else {
                if (!_object.divergingEpoch.equals(new EpochEndOffset())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default divergingEpoch at version " + _version);
                }
            }
            if (_version >= 12) {
                if (!_object.currentLeader.equals(new LeaderIdAndEpoch())) {
                    _node.set("currentLeader", LeaderIdAndEpochJsonConverter.write(_object.currentLeader, _version, _serializeRecords));
                }
            } else {
                if (!_object.currentLeader.equals(new LeaderIdAndEpoch())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default currentLeader at version " + _version);
                }
            }
            if (_version >= 12) {
                if (!_object.snapshotId.equals(new SnapshotId())) {
                    _node.set("snapshotId", SnapshotIdJsonConverter.write(_object.snapshotId, _version, _serializeRecords));
                }
            } else {
                if (!_object.snapshotId.equals(new SnapshotId())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default snapshotId at version " + _version);
                }
            }
            if (_version >= 4) {
                if (_object.abortedTransactions == null) {
                    _node.set("abortedTransactions", NullNode.instance);
                } else {
                    ArrayNode _abortedTransactionsArray = new ArrayNode(JsonNodeFactory.instance);
                    for (AbortedTransaction _element : _object.abortedTransactions) {
                        _abortedTransactionsArray.add(AbortedTransactionJsonConverter.write(_element, _version, _serializeRecords));
                    }
                    _node.set("abortedTransactions", _abortedTransactionsArray);
                }
            }
            if (_version >= 11) {
                _node.set("preferredReadReplica", new IntNode(_object.preferredReadReplica));
            } else {
                if (_object.preferredReadReplica != -1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default preferredReadReplica at version " + _version);
                }
            }
            if (_object.recordSet == null) {
                _node.set("recordSet", NullNode.instance);
            } else {
                if (_serializeRecords) {
                    _node.set("recordSet", new BinaryNode(new byte[]{}));
                } else {
                    _node.set("recordSetSizeInBytes", new IntNode(_object.recordSet.sizeInBytes()));
                }
            }
            return _node;
        }
        public static JsonNode write(FetchablePartitionResponse _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class FetchableTopicResponseJsonConverter {
        public static FetchableTopicResponse read(JsonNode _node, short _version) {
            FetchableTopicResponse _object = new FetchableTopicResponse();
            JsonNode _topicNode = _node.get("topic");
            if (_topicNode == null) {
                throw new RuntimeException("FetchableTopicResponse: unable to locate field 'topic', which is mandatory in version " + _version);
            } else {
                if (!_topicNode.isTextual()) {
                    throw new RuntimeException("FetchableTopicResponse expected a string type, but got " + _node.getNodeType());
                }
                _object.topic = _topicNode.asText();
            }
            JsonNode _partitionResponsesNode = _node.get("partitionResponses");
            if (_partitionResponsesNode == null) {
                throw new RuntimeException("FetchableTopicResponse: unable to locate field 'partitionResponses', which is mandatory in version " + _version);
            } else {
                if (!_partitionResponsesNode.isArray()) {
                    throw new RuntimeException("FetchableTopicResponse expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<FetchablePartitionResponse> _collection = new ArrayList<FetchablePartitionResponse>(_partitionResponsesNode.size());
                _object.partitionResponses = _collection;
                for (JsonNode _element : _partitionResponsesNode) {
                    _collection.add(FetchablePartitionResponseJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(FetchableTopicResponse _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("topic", new TextNode(_object.topic));
            ArrayNode _partitionResponsesArray = new ArrayNode(JsonNodeFactory.instance);
            for (FetchablePartitionResponse _element : _object.partitionResponses) {
                _partitionResponsesArray.add(FetchablePartitionResponseJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("partitionResponses", _partitionResponsesArray);
            return _node;
        }
        public static JsonNode write(FetchableTopicResponse _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class LeaderIdAndEpochJsonConverter {
        public static LeaderIdAndEpoch read(JsonNode _node, short _version) {
            LeaderIdAndEpoch _object = new LeaderIdAndEpoch();
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of LeaderIdAndEpoch");
            }
            JsonNode _leaderIdNode = _node.get("leaderId");
            if (_leaderIdNode == null) {
                throw new RuntimeException("LeaderIdAndEpoch: unable to locate field 'leaderId', which is mandatory in version " + _version);
            } else {
                _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "LeaderIdAndEpoch");
            }
            JsonNode _leaderEpochNode = _node.get("leaderEpoch");
            if (_leaderEpochNode == null) {
                throw new RuntimeException("LeaderIdAndEpoch: unable to locate field 'leaderEpoch', which is mandatory in version " + _version);
            } else {
                _object.leaderEpoch = MessageUtil.jsonNodeToInt(_leaderEpochNode, "LeaderIdAndEpoch");
            }
            return _object;
        }
        public static JsonNode write(LeaderIdAndEpoch _object, short _version, boolean _serializeRecords) {
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of LeaderIdAndEpoch");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("leaderId", new IntNode(_object.leaderId));
            _node.set("leaderEpoch", new IntNode(_object.leaderEpoch));
            return _node;
        }
        public static JsonNode write(LeaderIdAndEpoch _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class SnapshotIdJsonConverter {
        public static SnapshotId read(JsonNode _node, short _version) {
            SnapshotId _object = new SnapshotId();
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of SnapshotId");
            }
            JsonNode _endOffsetNode = _node.get("endOffset");
            if (_endOffsetNode == null) {
                throw new RuntimeException("SnapshotId: unable to locate field 'endOffset', which is mandatory in version " + _version);
            } else {
                _object.endOffset = MessageUtil.jsonNodeToLong(_endOffsetNode, "SnapshotId");
            }
            JsonNode _epochNode = _node.get("epoch");
            if (_epochNode == null) {
                throw new RuntimeException("SnapshotId: unable to locate field 'epoch', which is mandatory in version " + _version);
            } else {
                _object.epoch = MessageUtil.jsonNodeToInt(_epochNode, "SnapshotId");
            }
            return _object;
        }
        public static JsonNode write(SnapshotId _object, short _version, boolean _serializeRecords) {
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of SnapshotId");
            }
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("endOffset", new LongNode(_object.endOffset));
            _node.set("epoch", new IntNode(_object.epoch));
            return _node;
        }
        public static JsonNode write(SnapshotId _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
