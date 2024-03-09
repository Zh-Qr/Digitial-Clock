import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlay2 {
	// private String path; //带路径的音频文件
	private AudioInputStream audioStream;
	private AudioFormat audioFormat;
	private SourceDataLine sourceDataLine;

	public AudioPlay2(String path) {
		playMusic(path);
	}

	private void playMusic(String path) {
		try {
			int count;
			byte buf[] = new byte[1024];

			// 获取音频输入�?
			audioStream = AudioSystem.getAudioInputStream(new File(path));
			// 获取音频的编码格�?
			audioFormat = audioStream.getFormat();

			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
					audioFormat, AudioSystem.NOT_SPECIFIED);

			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

			sourceDataLine.open(audioFormat);
			sourceDataLine.start();
			// 播放音频
			while ((count = audioStream.read(buf, 0, buf.length)) != -1) {
				sourceDataLine.write(buf, 0, count);
			}
			// 播放结束，释放资�?
			sourceDataLine.drain();
			sourceDataLine.close();
			audioStream.close();
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void ringmusic() {
		String path = "张晓涵_戚琦-绝世舞姬.wav";
		new AudioPlay2(path);
	}

	public static void main(String[] args) {
		// String path =
		// "/Users/zhongqirui/Desktop/programming/java/digitialClock/张晓涵_戚琦-绝世舞姬.wav";
		// new AudioPlay2(path);
		ringmusic();
	}
}
