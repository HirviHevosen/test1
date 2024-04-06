import {TextField} from "@hilla/react-components/TextField";
import {EmailField} from "@hilla/react-components/EmailField";
import {Select, SelectItem} from "@hilla/react-components/Select";
import {Button} from "@hilla/react-components/Button";
import {useForm} from "@hilla/react-form";
import FormSubmissionRecordModel from "Frontend/generated/com/example/application/services/SettingsService/FormSubmissionRecordModel";
import CloudSchemaRecord from "Frontend/generated/com/example/application/services/SettingsService/CloudSchemaRecord";
import FormSubmissionRecord from "Frontend/generated/com/example/application/services/SettingsService/FormSubmissionRecord";
import {SettingsService} from "Frontend/generated/endpoints";
import {useEffect, useState} from "react";
import Form from '@rjsf/core';
import { RJSFSchema } from '@rjsf/utils';
import validator from '@rjsf/validator-ajv8';

interface SchemasFormProps {
    schema?: CloudSchemaRecord | null;
    onSubmit: ( contact: FormSubmissionRecord) => Promise<void>;
}

export default function ContactForm({schema, onSubmit}: SchemasFormProps) {

    const [companies, setCompanies] = useState<SelectItem[]>([]);
    const [schemad, setSchemad] = useState<RJSFSchema>(JSON.parse((schema as CloudSchemaRecord)?.schema_data) || {});

    const [formData, setFormData] = useState<Object|null>(null);

    const [formSubmission, setFormSubmission] = useState<FormSubmissionRecord>({
            data: JSON.stringify({}),
            cloudSchema: schema as CloudSchemaRecord,
            id: null
    } as unknown as FormSubmissionRecord);

    useEffect(() => {
        if(schema){
            SettingsService.findFormSubmission(schema as CloudSchemaRecord).then((e)=>{
            setFormSubmission(e as FormSubmissionRecord);
            setFormData(JSON.parse((e as FormSubmissionRecord).data))
            });
        }

    }, [schema]);

    async function changeFormData(formDatan: any){
        if(formData!==null){
            
    setFormSubmission({...formSubmission, data: JSON.stringify(formDatan)})

      onSubmit(formSubmission);
        setFormData(formDatan);
        }
    }

    return (
        <div className="flex flex-col gap-s items-start">
        <Form
            schema={schemad}
            formData={formData}
            validator={validator}
            onChange={(e) => changeFormData( e.formData)}
            onBlur={(e) => changeFormData(formData)}
        />
        </div>
    )
}