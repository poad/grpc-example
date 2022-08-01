// This file is generated by rust-protobuf 3.1.0. Do not edit
// .proto file is parsed by protoc --rust-out=...
// @generated

// https://github.com/rust-lang/rust-clippy/issues/702
#![allow(unknown_lints)]
#![allow(clippy::all)]

#![allow(unused_attributes)]
#![cfg_attr(rustfmt, rustfmt::skip)]

#![allow(box_pointers)]
#![allow(dead_code)]
#![allow(missing_docs)]
#![allow(non_camel_case_types)]
#![allow(non_snake_case)]
#![allow(non_upper_case_globals)]
#![allow(trivial_casts)]
#![allow(unused_results)]
#![allow(unused_mut)]

//! Generated file from `hello.proto`

/// Generated files are compatible only with the same version
/// of protobuf runtime.
const _PROTOBUF_VERSION_CHECK: () = ::protobuf::VERSION_3_1_0;

///  The request message containing the user's name.
#[derive(PartialEq,Clone,Default,Debug)]
// @@protoc_insertion_point(message:hello.HelloRequest)
pub struct HelloRequest {
    // message fields
    // @@protoc_insertion_point(field:hello.HelloRequest.name)
    pub name: ::std::string::String,
    // special fields
    // @@protoc_insertion_point(special_field:hello.HelloRequest.special_fields)
    pub special_fields: ::protobuf::SpecialFields,
}

impl<'a> ::std::default::Default for &'a HelloRequest {
    fn default() -> &'a HelloRequest {
        <HelloRequest as ::protobuf::Message>::default_instance()
    }
}

impl HelloRequest {
    pub fn new() -> HelloRequest {
        ::std::default::Default::default()
    }

    fn generated_message_descriptor_data() -> ::protobuf::reflect::GeneratedMessageDescriptorData {
        let mut fields = ::std::vec::Vec::with_capacity(1);
        let mut oneofs = ::std::vec::Vec::with_capacity(0);
        fields.push(::protobuf::reflect::rt::v2::make_simpler_field_accessor::<_, _>(
            "name",
            |m: &HelloRequest| { &m.name },
            |m: &mut HelloRequest| { &mut m.name },
        ));
        ::protobuf::reflect::GeneratedMessageDescriptorData::new_2::<HelloRequest>(
            "HelloRequest",
            fields,
            oneofs,
        )
    }
}

impl ::protobuf::Message for HelloRequest {
    const NAME: &'static str = "HelloRequest";

    fn is_initialized(&self) -> bool {
        true
    }

    fn merge_from(&mut self, is: &mut ::protobuf::CodedInputStream<'_>) -> ::protobuf::Result<()> {
        while let Some(tag) = is.read_raw_tag_or_eof()? {
            match tag {
                10 => {
                    self.name = is.read_string()?;
                },
                tag => {
                    ::protobuf::rt::read_unknown_or_skip_group(tag, is, self.special_fields.mut_unknown_fields())?;
                },
            };
        }
        ::std::result::Result::Ok(())
    }

    // Compute sizes of nested messages
    #[allow(unused_variables)]
    fn compute_size(&self) -> u64 {
        let mut my_size = 0;
        if !self.name.is_empty() {
            my_size += ::protobuf::rt::string_size(1, &self.name);
        }
        my_size += ::protobuf::rt::unknown_fields_size(self.special_fields.unknown_fields());
        self.special_fields.cached_size().set(my_size as u32);
        my_size
    }

    fn write_to_with_cached_sizes(&self, os: &mut ::protobuf::CodedOutputStream<'_>) -> ::protobuf::Result<()> {
        if !self.name.is_empty() {
            os.write_string(1, &self.name)?;
        }
        os.write_unknown_fields(self.special_fields.unknown_fields())?;
        ::std::result::Result::Ok(())
    }

    fn special_fields(&self) -> &::protobuf::SpecialFields {
        &self.special_fields
    }

    fn mut_special_fields(&mut self) -> &mut ::protobuf::SpecialFields {
        &mut self.special_fields
    }

    fn new() -> HelloRequest {
        HelloRequest::new()
    }

    fn clear(&mut self) {
        self.name.clear();
        self.special_fields.clear();
    }

    fn default_instance() -> &'static HelloRequest {
        static instance: HelloRequest = HelloRequest {
            name: ::std::string::String::new(),
            special_fields: ::protobuf::SpecialFields::new(),
        };
        &instance
    }
}

impl ::protobuf::MessageFull for HelloRequest {
    fn descriptor() -> ::protobuf::reflect::MessageDescriptor {
        static descriptor: ::protobuf::rt::Lazy<::protobuf::reflect::MessageDescriptor> = ::protobuf::rt::Lazy::new();
        descriptor.get(|| file_descriptor().message_by_package_relative_name("HelloRequest").unwrap()).clone()
    }
}

impl ::std::fmt::Display for HelloRequest {
    fn fmt(&self, f: &mut ::std::fmt::Formatter<'_>) -> ::std::fmt::Result {
        ::protobuf::text_format::fmt(self, f)
    }
}

impl ::protobuf::reflect::ProtobufValue for HelloRequest {
    type RuntimeType = ::protobuf::reflect::rt::RuntimeTypeMessage<Self>;
}

///  The response message containing the greetings
#[derive(PartialEq,Clone,Default,Debug)]
// @@protoc_insertion_point(message:hello.HelloReply)
pub struct HelloReply {
    // message fields
    // @@protoc_insertion_point(field:hello.HelloReply.message)
    pub message: ::std::string::String,
    // special fields
    // @@protoc_insertion_point(special_field:hello.HelloReply.special_fields)
    pub special_fields: ::protobuf::SpecialFields,
}

impl<'a> ::std::default::Default for &'a HelloReply {
    fn default() -> &'a HelloReply {
        <HelloReply as ::protobuf::Message>::default_instance()
    }
}

impl HelloReply {
    pub fn new() -> HelloReply {
        ::std::default::Default::default()
    }

    fn generated_message_descriptor_data() -> ::protobuf::reflect::GeneratedMessageDescriptorData {
        let mut fields = ::std::vec::Vec::with_capacity(1);
        let mut oneofs = ::std::vec::Vec::with_capacity(0);
        fields.push(::protobuf::reflect::rt::v2::make_simpler_field_accessor::<_, _>(
            "message",
            |m: &HelloReply| { &m.message },
            |m: &mut HelloReply| { &mut m.message },
        ));
        ::protobuf::reflect::GeneratedMessageDescriptorData::new_2::<HelloReply>(
            "HelloReply",
            fields,
            oneofs,
        )
    }
}

impl ::protobuf::Message for HelloReply {
    const NAME: &'static str = "HelloReply";

    fn is_initialized(&self) -> bool {
        true
    }

    fn merge_from(&mut self, is: &mut ::protobuf::CodedInputStream<'_>) -> ::protobuf::Result<()> {
        while let Some(tag) = is.read_raw_tag_or_eof()? {
            match tag {
                10 => {
                    self.message = is.read_string()?;
                },
                tag => {
                    ::protobuf::rt::read_unknown_or_skip_group(tag, is, self.special_fields.mut_unknown_fields())?;
                },
            };
        }
        ::std::result::Result::Ok(())
    }

    // Compute sizes of nested messages
    #[allow(unused_variables)]
    fn compute_size(&self) -> u64 {
        let mut my_size = 0;
        if !self.message.is_empty() {
            my_size += ::protobuf::rt::string_size(1, &self.message);
        }
        my_size += ::protobuf::rt::unknown_fields_size(self.special_fields.unknown_fields());
        self.special_fields.cached_size().set(my_size as u32);
        my_size
    }

    fn write_to_with_cached_sizes(&self, os: &mut ::protobuf::CodedOutputStream<'_>) -> ::protobuf::Result<()> {
        if !self.message.is_empty() {
            os.write_string(1, &self.message)?;
        }
        os.write_unknown_fields(self.special_fields.unknown_fields())?;
        ::std::result::Result::Ok(())
    }

    fn special_fields(&self) -> &::protobuf::SpecialFields {
        &self.special_fields
    }

    fn mut_special_fields(&mut self) -> &mut ::protobuf::SpecialFields {
        &mut self.special_fields
    }

    fn new() -> HelloReply {
        HelloReply::new()
    }

    fn clear(&mut self) {
        self.message.clear();
        self.special_fields.clear();
    }

    fn default_instance() -> &'static HelloReply {
        static instance: HelloReply = HelloReply {
            message: ::std::string::String::new(),
            special_fields: ::protobuf::SpecialFields::new(),
        };
        &instance
    }
}

impl ::protobuf::MessageFull for HelloReply {
    fn descriptor() -> ::protobuf::reflect::MessageDescriptor {
        static descriptor: ::protobuf::rt::Lazy<::protobuf::reflect::MessageDescriptor> = ::protobuf::rt::Lazy::new();
        descriptor.get(|| file_descriptor().message_by_package_relative_name("HelloReply").unwrap()).clone()
    }
}

impl ::std::fmt::Display for HelloReply {
    fn fmt(&self, f: &mut ::std::fmt::Formatter<'_>) -> ::std::fmt::Result {
        ::protobuf::text_format::fmt(self, f)
    }
}

impl ::protobuf::reflect::ProtobufValue for HelloReply {
    type RuntimeType = ::protobuf::reflect::rt::RuntimeTypeMessage<Self>;
}

static file_descriptor_proto_data: &'static [u8] = b"\
    \n\x0bhello.proto\x12\x05hello\"\"\n\x0cHelloRequest\x12\x12\n\x04name\
    \x18\x01\x20\x01(\tR\x04name\"&\n\nHelloReply\x12\x18\n\x07message\x18\
    \x01\x20\x01(\tR\x07message2?\n\x07Greeter\x124\n\x08SayHello\x12\x13.he\
    llo.HelloRequest\x1a\x11.hello.HelloReply\"\0B-\n\x1ccom.github.poad.exa\
    mple.grpcB\x05HelloP\x01\xa2\x02\x03HLWJ\xf9\x03\n\x06\x12\x04\0\0\x18\
    \x01\n\x08\n\x01\x0c\x12\x03\0\0\x12\n\x08\n\x01\x08\x12\x03\x02\0\"\n\t\
    \n\x02\x08\n\x12\x03\x02\0\"\n\x08\n\x01\x08\x12\x03\x03\05\n\t\n\x02\
    \x08\x01\x12\x03\x03\05\n\x08\n\x01\x08\x12\x03\x04\0&\n\t\n\x02\x08\x08\
    \x12\x03\x04\0&\n\x08\n\x01\x08\x12\x03\x05\0!\n\t\n\x02\x08$\x12\x03\
    \x05\0!\n\x08\n\x01\x02\x12\x03\x07\0\x0e\n.\n\x02\x06\0\x12\x04\x0b\0\
    \x0e\x01\x1a\"\x20The\x20greeting\x20service\x20definition.\n\n\n\n\x03\
    \x06\0\x01\x12\x03\x0b\x08\x0f\n\x1f\n\x04\x06\0\x02\0\x12\x03\r\x047\
    \x1a\x12\x20Sends\x20a\x20greeting\n\n\x0c\n\x05\x06\0\x02\0\x01\x12\x03\
    \r\x08\x10\n\x0c\n\x05\x06\0\x02\0\x02\x12\x03\r\x12\x1e\n\x0c\n\x05\x06\
    \0\x02\0\x03\x12\x03\r)3\n=\n\x02\x04\0\x12\x04\x11\0\x13\x01\x1a1\x20Th\
    e\x20request\x20message\x20containing\x20the\x20user's\x20name.\n\n\n\n\
    \x03\x04\0\x01\x12\x03\x11\x08\x14\n\x0b\n\x04\x04\0\x02\0\x12\x03\x12\
    \x04\x14\n\x0c\n\x05\x04\0\x02\0\x05\x12\x03\x12\x04\n\n\x0c\n\x05\x04\0\
    \x02\0\x01\x12\x03\x12\x0b\x0f\n\x0c\n\x05\x04\0\x02\0\x03\x12\x03\x12\
    \x12\x13\n;\n\x02\x04\x01\x12\x04\x16\0\x18\x01\x1a/\x20The\x20response\
    \x20message\x20containing\x20the\x20greetings\n\n\n\n\x03\x04\x01\x01\
    \x12\x03\x16\x08\x12\n\x0b\n\x04\x04\x01\x02\0\x12\x03\x17\x04\x17\n\x0c\
    \n\x05\x04\x01\x02\0\x05\x12\x03\x17\x04\n\n\x0c\n\x05\x04\x01\x02\0\x01\
    \x12\x03\x17\x0b\x12\n\x0c\n\x05\x04\x01\x02\0\x03\x12\x03\x17\x15\x16b\
    \x06proto3\
";

/// `FileDescriptorProto` object which was a source for this generated file
fn file_descriptor_proto() -> &'static ::protobuf::descriptor::FileDescriptorProto {
    static file_descriptor_proto_lazy: ::protobuf::rt::Lazy<::protobuf::descriptor::FileDescriptorProto> = ::protobuf::rt::Lazy::new();
    file_descriptor_proto_lazy.get(|| {
        ::protobuf::Message::parse_from_bytes(file_descriptor_proto_data).unwrap()
    })
}

/// `FileDescriptor` object which allows dynamic access to files
pub fn file_descriptor() -> &'static ::protobuf::reflect::FileDescriptor {
    static generated_file_descriptor_lazy: ::protobuf::rt::Lazy<::protobuf::reflect::GeneratedFileDescriptor> = ::protobuf::rt::Lazy::new();
    static file_descriptor: ::protobuf::rt::Lazy<::protobuf::reflect::FileDescriptor> = ::protobuf::rt::Lazy::new();
    file_descriptor.get(|| {
        let generated_file_descriptor = generated_file_descriptor_lazy.get(|| {
            let mut deps = ::std::vec::Vec::with_capacity(0);
            let mut messages = ::std::vec::Vec::with_capacity(2);
            messages.push(HelloRequest::generated_message_descriptor_data());
            messages.push(HelloReply::generated_message_descriptor_data());
            let mut enums = ::std::vec::Vec::with_capacity(0);
            ::protobuf::reflect::GeneratedFileDescriptor::new_generated(
                file_descriptor_proto(),
                deps,
                messages,
                enums,
            )
        });
        ::protobuf::reflect::FileDescriptor::new_generated_2(generated_file_descriptor)
    })
}
