package com.izforge.izpack.api.event;

import java.io.File;

import com.izforge.izpack.api.data.Pack;
import com.izforge.izpack.api.data.PackFile;
import com.izforge.izpack.api.exception.IzPackException;


/**
 * A listener for file installation events.
 *
 * @author Tim Anderson
 */
public interface FileListener extends InstallListener
{

    /**
     * Initialises the listener.
     *
     * @throws IzPackException for any error
     */
    void initialise();

    /**
     * Invoked before a directory is created.
     *
     * @param dir      the directory
     * @param packFile the corresponding pack file
     * @param pack     the pack that {@code packFile} comes from
     * @throws IzPackException for any error
     */
    void beforeDir(File dir, PackFile packFile, Pack pack);

    /**
     * Invoked after a directory is created.
     *
     * @param dir      the directory
     * @param packFile the corresponding pack file
     * @param pack     the pack that {@code packFile} comes from
     * @throws IzPackException for any error
     */
    void afterDir(File dir, PackFile packFile, Pack pack);

    /**
     * Invoked before a file is installed.
     *
     * @param file     the file
     * @param packFile the corresponding pack file
     * @param pack     the pack that {@code packFile} comes from
     * @throws IzPackException for any error
     */
    void beforeFile(File file, PackFile packFile, Pack pack);

    /**
     * Invoked after a file is installed.
     *
     * @param file     the file
     * @param packFile the corresponding pack file
     * @param pack     the pack that {@code packFile} comes from
     * @throws IzPackException for any error
     */
    void afterFile(File file, PackFile packFile, Pack pack);

}