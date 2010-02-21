package com.izforge.izpack.merge;

import com.izforge.izpack.merge.resolve.PathResolver;
import org.apache.tools.zip.ZipOutputStream;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * A mergeable file allow to chose files to merge in the installer.<br />
 * The source can be files in jar or directory. You may also filters sources with a given regexp.
 *
 * @author Anthonin Bonnefoy
 */
public class MergeManagerImpl implements MergeManager {


    private List<Mergeable> mergeableList;

    public MergeManagerImpl() {
        mergeableList = new ArrayList<Mergeable>();
    }

    public void addResourceToMerge(Mergeable mergeable) {
        mergeableList.add(mergeable);
    }

    public void addResourceToMerge(String resourcePath) {
        mergeableList.addAll(PathResolver.getMergeableFromPath(resourcePath));
    }

    public void addResourceToMerge(String resourcePath, String destination) {
        mergeableList.addAll(PathResolver.getMergeableFromPath(resourcePath, destination));
    }

    public void merge(ZipOutputStream outputStream) {
        for (Mergeable mergeable : mergeableList) {
            mergeable.merge(outputStream);
        }
        mergeableList.clear();
    }

    public void merge(java.util.zip.ZipOutputStream outputStream) {
        for (Mergeable mergeable : mergeableList) {
            mergeable.merge(outputStream);
        }
        mergeableList.clear();
    }

    public File find(FileFilter fileFilter) {
        for (Mergeable mergeable : mergeableList) {
            File file = mergeable.find(fileFilter);
            if (file != null) {
                return file;
            }
        }
        return null;
    }
}