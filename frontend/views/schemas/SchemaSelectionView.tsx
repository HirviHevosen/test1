import CloudSchemaRecord from 'Frontend/generated/com/example/application/services/SettingsService/CloudSchemaRecord';
import FormSubmissionRecord from 'Frontend/generated/com/example/application/services/SettingsService/FormSubmissionRecord';
import {useEffect, useState} from 'react';
import {SettingsService} from "Frontend/generated/endpoints";
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import SchemaForm from "Frontend/views/schemas/SchemasForm";

export default function SchemaSelectionView() {
    const [cloudSchemas, setCloudSchemas] = useState<CloudSchemaRecord[]>([]);
    const [selected, setSelected] = useState<CloudSchemaRecord | null | undefined>();

    useEffect(() => {
        SettingsService.findAllSchemas().then(setCloudSchemas);
    }, []);

    async function onFormSaved(contact: FormSubmissionRecord) {

        const saved = await SettingsService.save(contact);

    }

    return (
        <div className="p-m flex gap-m">
            <Grid
                items={cloudSchemas}
                onActiveItemChanged={e => setSelected(e.detail.value)}
                selectedItems={[selected]}>

                <GridColumn path="name"/>
            </Grid>

            {selected &&
                <SchemaForm schema={selected} onSubmit={onFormSaved}/>
            }
        </div>
    );
}