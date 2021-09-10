package commons.compress.zip;

import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jion
 *  压缩文件为Zip
 */
public class CompressZipExample {

    /** 压缩单个文件 */
    @Test
    public void compressFileToZip() throws IOException {
        // 文件路径
        File file = new File("S:\\dir\\2018\\文件旧.txt");
        // 输出路径
        File zipFile = new File("S:\\文件夹.zip");
        ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(zipFile);
        // 压缩配置
        zipArchiveOutputStream.setEncoding("UTF-8");
        zipArchiveOutputStream.setUseZip64(Zip64Mode.AsNeeded);
        // 存放压缩文件,压缩后文件名
        ZipArchiveEntry zipArchiveEntry  = new ZipArchiveEntry(file,file.getName());
        zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
        // 从文件拷贝到输出流
        FileUtils.copyFile(file,zipArchiveOutputStream);
        // 关闭
        zipArchiveOutputStream.closeArchiveEntry();
        zipArchiveOutputStream.close();
    }

}
