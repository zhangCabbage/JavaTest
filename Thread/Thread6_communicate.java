package zhang.algorithm.JavaTest.Thread;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/17
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public class Thread6_communicate {
    //------------------------------------------------------------------------------------
    //
    //------------------------------------------------------------------------------------

    static class WriteData {
        /**
         * 写入字节
         *
         * @param output
         */
        public void writeByte(PipedOutputStream output) {
            try {
                System.out.println("output...");
                for (int i = 0; i < 30; i++) {
                    String outData = "" + (i + 1);
                    output.write(outData.getBytes());
                    System.out.print(outData);
                }
                System.out.println();
                output.close();
            } catch (IOException e) {

            }
        }

        /**
         * 写入字符
         *
         * @param writer
         */
        public void writeChar(PipedWriter writer) {
            try {
                System.out.println("writer...");
                for (int i = 0; i < 30; i++) {
                    String outData = "" + (i + 1);
                    writer.write(outData);
                    System.out.print(outData);
                }
                System.out.println();
                writer.close();
            } catch (IOException e) {

            }
        }
    }

    static class ReadData {
        /**
         * 读取字节
         *
         * @param input
         */
        public void readByte(PipedInputStream input) {
            try {
                System.out.println("input...");
                byte[] tmp = new byte[20];
                int inputLength;
                while ((inputLength = input.read(tmp)) != -1) {
                    String inputData = new String(tmp, 0, inputLength);
                    System.out.print(inputData);
                }
                System.out.println();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 读取字符
         *
         * @param reader
         * @return
         */
        public String readChar(PipedReader reader) {
            try {
                System.out.println("reader...");
                char[] tmp = new char[20];
                int inputLength;
                while ((inputLength = reader.read(tmp)) != -1) {
                    String inputData = new String(tmp, 0, inputLength);
                    System.out.print(inputData);
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    //------------------------------------------------------------------------------------
    //
    //------------------------------------------------------------------------------------
    static class ThreadInput extends Thread {
        PipedInputStream input;
        ReadData readData;

        public ThreadInput(ReadData readData, PipedInputStream input) {
            this.readData = readData;
            this.input = input;
        }

        @Override
        public void run() {
            super.run();
            readData.readByte(input);
        }
    }

    static class ThreadOutput extends Thread {
        PipedOutputStream output;
        WriteData writeData;

        public ThreadOutput(WriteData writeData, PipedOutputStream output) {
            this.writeData = writeData;
            this.output = output;
        }

        @Override
        public void run() {
            super.run();
            writeData.writeByte(output);
        }
    }

    //------------------------------------------------------------------------------------
    //
    //------------------------------------------------------------------------------------
    static class ThreadReader extends Thread {
        PipedReader reader;
        ReadData readData;

        public ThreadReader(ReadData readData, PipedReader reader) {
            this.readData = readData;
            this.reader = reader;
        }

        @Override
        public void run() {
            super.run();
            readData.readChar(reader);
        }
    }

    static class ThreadWriter extends Thread {
        PipedWriter writer;
        WriteData writeData;

        public ThreadWriter(WriteData writeData, PipedWriter writer) {
            this.writeData = writeData;
            this.writer = writer;
        }

        @Override
        public void run() {
            super.run();
            writeData.writeChar(writer);
        }
    }

    //------------------------------------------------------------------------------------
    //
    //------------------------------------------------------------------------------------
    public static void inputOutput() {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream input = new PipedInputStream();
            PipedOutputStream output = new PipedOutputStream();

            input.connect(output); //

            ThreadInput threadInput = new ThreadInput(readData, input);
            threadInput.start();

            Thread.sleep(3000);

            ThreadOutput threadOutput = new ThreadOutput(writeData, output);
            threadOutput.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void readerWriter() {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedReader reader = new PipedReader();
            PipedWriter writer = new PipedWriter();

            reader.connect(writer); //

            ThreadReader threadReader = new ThreadReader(readData, reader);
            threadReader.start();

            Thread.sleep(3000);

            ThreadWriter threadWriter = new ThreadWriter(writeData, writer);
            threadWriter.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        inputOutput();
        readerWriter();
        Lock lock = new ReentrantLock();
    }
}
