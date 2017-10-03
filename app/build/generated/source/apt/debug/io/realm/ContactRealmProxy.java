package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactRealmProxy extends au.elegantmedia.com.contactapp.models.Contact
    implements RealmObjectProxy, ContactRealmProxyInterface {

    static final class ContactColumnInfo extends ColumnInfo
        implements Cloneable {

        public long imageIndex;
        public long nameIndex;
        public long emailIndex;
        public long phoneIndex;

        ContactColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.imageIndex = getValidColumnIndex(path, table, "Contact", "image");
            indicesMap.put("image", this.imageIndex);
            this.nameIndex = getValidColumnIndex(path, table, "Contact", "name");
            indicesMap.put("name", this.nameIndex);
            this.emailIndex = getValidColumnIndex(path, table, "Contact", "email");
            indicesMap.put("email", this.emailIndex);
            this.phoneIndex = getValidColumnIndex(path, table, "Contact", "phone");
            indicesMap.put("phone", this.phoneIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ContactColumnInfo otherInfo = (ContactColumnInfo) other;
            this.imageIndex = otherInfo.imageIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.emailIndex = otherInfo.emailIndex;
            this.phoneIndex = otherInfo.phoneIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ContactColumnInfo clone() {
            return (ContactColumnInfo) super.clone();
        }

    }
    private ContactColumnInfo columnInfo;
    private ProxyState<au.elegantmedia.com.contactapp.models.Contact> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("image");
        fieldNames.add("name");
        fieldNames.add("email");
        fieldNames.add("phone");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ContactRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ContactColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<au.elegantmedia.com.contactapp.models.Contact>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$phone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneIndex);
    }

    public void realmSet$phone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Contact")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Contact");
            realmObjectSchema.add(new Property("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("phone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Contact");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Contact")) {
            Table table = sharedRealm.getTable("class_Contact");
            table.addColumn(RealmFieldType.STRING, "image", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "email", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "phone", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_Contact");
    }

    public static ContactColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Contact")) {
            Table table = sharedRealm.getTable("class_Contact");
            final long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ContactColumnInfo columnInfo = new ContactColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("image")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'image' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("image") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'image' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.imageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'image' is required. Either set @Required to field 'image' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.emailIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("phone")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'phone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("phone") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'phone' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.phoneIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'phone' is required. Either set @Required to field 'phone' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Contact' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Contact";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static au.elegantmedia.com.contactapp.models.Contact createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        au.elegantmedia.com.contactapp.models.Contact obj = realm.createObjectInternal(au.elegantmedia.com.contactapp.models.Contact.class, true, excludeFields);
        if (json.has("image")) {
            if (json.isNull("image")) {
                ((ContactRealmProxyInterface) obj).realmSet$image(null);
            } else {
                ((ContactRealmProxyInterface) obj).realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ContactRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ContactRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((ContactRealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((ContactRealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("phone")) {
            if (json.isNull("phone")) {
                ((ContactRealmProxyInterface) obj).realmSet$phone(null);
            } else {
                ((ContactRealmProxyInterface) obj).realmSet$phone((String) json.getString("phone"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static au.elegantmedia.com.contactapp.models.Contact createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        au.elegantmedia.com.contactapp.models.Contact obj = new au.elegantmedia.com.contactapp.models.Contact();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("image")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContactRealmProxyInterface) obj).realmSet$image(null);
                } else {
                    ((ContactRealmProxyInterface) obj).realmSet$image((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContactRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ContactRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContactRealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((ContactRealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else if (name.equals("phone")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContactRealmProxyInterface) obj).realmSet$phone(null);
                } else {
                    ((ContactRealmProxyInterface) obj).realmSet$phone((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static au.elegantmedia.com.contactapp.models.Contact copyOrUpdate(Realm realm, au.elegantmedia.com.contactapp.models.Contact object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (au.elegantmedia.com.contactapp.models.Contact) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static au.elegantmedia.com.contactapp.models.Contact copy(Realm realm, au.elegantmedia.com.contactapp.models.Contact newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (au.elegantmedia.com.contactapp.models.Contact) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            au.elegantmedia.com.contactapp.models.Contact realmObject = realm.createObjectInternal(au.elegantmedia.com.contactapp.models.Contact.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ContactRealmProxyInterface) realmObject).realmSet$image(((ContactRealmProxyInterface) newObject).realmGet$image());
            ((ContactRealmProxyInterface) realmObject).realmSet$name(((ContactRealmProxyInterface) newObject).realmGet$name());
            ((ContactRealmProxyInterface) realmObject).realmSet$email(((ContactRealmProxyInterface) newObject).realmGet$email());
            ((ContactRealmProxyInterface) realmObject).realmSet$phone(((ContactRealmProxyInterface) newObject).realmGet$phone());
            return realmObject;
        }
    }

    public static long insert(Realm realm, au.elegantmedia.com.contactapp.models.Contact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(au.elegantmedia.com.contactapp.models.Contact.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(au.elegantmedia.com.contactapp.models.Contact.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$image = ((ContactRealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        String realmGet$name = ((ContactRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$email = ((ContactRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$phone = ((ContactRealmProxyInterface)object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(au.elegantmedia.com.contactapp.models.Contact.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(au.elegantmedia.com.contactapp.models.Contact.class);
        au.elegantmedia.com.contactapp.models.Contact object = null;
        while (objects.hasNext()) {
            object = (au.elegantmedia.com.contactapp.models.Contact) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$image = ((ContactRealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                }
                String realmGet$name = ((ContactRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$email = ((ContactRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
                String realmGet$phone = ((ContactRealmProxyInterface)object).realmGet$phone();
                if (realmGet$phone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, au.elegantmedia.com.contactapp.models.Contact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(au.elegantmedia.com.contactapp.models.Contact.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(au.elegantmedia.com.contactapp.models.Contact.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$image = ((ContactRealmProxyInterface)object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        String realmGet$name = ((ContactRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$email = ((ContactRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$phone = ((ContactRealmProxyInterface)object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(au.elegantmedia.com.contactapp.models.Contact.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(au.elegantmedia.com.contactapp.models.Contact.class);
        au.elegantmedia.com.contactapp.models.Contact object = null;
        while (objects.hasNext()) {
            object = (au.elegantmedia.com.contactapp.models.Contact) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$image = ((ContactRealmProxyInterface)object).realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
                }
                String realmGet$name = ((ContactRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$email = ((ContactRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
                String realmGet$phone = ((ContactRealmProxyInterface)object).realmGet$phone();
                if (realmGet$phone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
                }
            }
        }
    }

    public static au.elegantmedia.com.contactapp.models.Contact createDetachedCopy(au.elegantmedia.com.contactapp.models.Contact realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        au.elegantmedia.com.contactapp.models.Contact unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (au.elegantmedia.com.contactapp.models.Contact)cachedObject.object;
            } else {
                unmanagedObject = (au.elegantmedia.com.contactapp.models.Contact)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new au.elegantmedia.com.contactapp.models.Contact();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ContactRealmProxyInterface) unmanagedObject).realmSet$image(((ContactRealmProxyInterface) realmObject).realmGet$image());
        ((ContactRealmProxyInterface) unmanagedObject).realmSet$name(((ContactRealmProxyInterface) realmObject).realmGet$name());
        ((ContactRealmProxyInterface) unmanagedObject).realmSet$email(((ContactRealmProxyInterface) realmObject).realmGet$email());
        ((ContactRealmProxyInterface) unmanagedObject).realmSet$phone(((ContactRealmProxyInterface) realmObject).realmGet$phone());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Contact = [");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phone:");
        stringBuilder.append(realmGet$phone() != null ? realmGet$phone() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactRealmProxy aContact = (ContactRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aContact.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aContact.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aContact.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
