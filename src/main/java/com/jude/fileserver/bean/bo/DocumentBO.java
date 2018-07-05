package com.jude.fileserver.bean.bo;

import com.jude.fileserver.bean.dao.DocumentDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocumentBO {
    private Long id;

    private String fileName;

    private String path;

    public DocumentDO to(){
        DocumentDO documentDO = new DocumentDO();
        documentDO.setFileName(this.fileName);
        documentDO.setId(this.id);
        documentDO.setFileName(this.path);
        return documentDO;
    }

    public static DocumentBO from(DocumentDO documentDO){
        DocumentBO documentBO = new DocumentBO();
        documentBO.setFileName(documentDO.getFileName());
        documentBO.setId(documentDO.getId());
        documentBO.setPath(documentDO.getPath());
        return documentBO;
    }
}
